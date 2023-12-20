package de.duke2k.gpxviewer;

import com.flowingcode.vaadin.addons.googlemaps.GoogleMap;
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPoint;
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPolygon;
import com.flowingcode.vaadin.addons.googlemaps.LatLon;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeLabel;
import de.duke2k.gpxviewer.config.GpxViewConfiguration;
import de.duke2k.gpxviewer.xjc.GpxType;
import de.duke2k.gpxviewer.xjc.WptType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_ASPECT_RATIO;
import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_WIDTH;
import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_WIDTH_PX;
import static de.duke2k.gpxviewer.util.GpxUtils.findCentre;
import static de.duke2k.gpxviewer.util.GpxUtils.findIdealZoomFactor;
import static de.duke2k.gpxviewer.util.GpxUtils.getDistance;

@Log
@Component
public class GpxView extends Div {

  private final GpxReader gpxReader;
  private final NativeLabel distanceAndElevationLabel;
  private List<WptType> waypoints;
  private GoogleMap googleMap;

  @Autowired
  public GpxView(GpxReader gpxReader,
                 @Qualifier("distanceAndElevationLabel") NativeLabel distanceAndElevationLabel,
                 GpxViewConfiguration configuration) {
    this.gpxReader = gpxReader;
    this.distanceAndElevationLabel = distanceAndElevationLabel;
    initMap(configuration.getApiKey(), configuration.getClientId());
    setId("map");
  }

  public void loadGpxRoute(@Nonnull File gpxFile) {
    try {
      GpxType gpx = gpxReader.readFromFile(gpxFile).getValue();
      extractWaypoints(gpx);
      double distance = 0.0;
      double elevation = 0.0;
      WptType previousWpt = null;
      for (WptType wpt : waypoints) {
        if (previousWpt != null) {
          distance += getDistance(previousWpt.getLat().doubleValue(), previousWpt.getLon().doubleValue(),
              wpt.getLat().doubleValue(), wpt.getLon().doubleValue());
          double intElev = wpt.getEle().doubleValue() - previousWpt.getEle().doubleValue();
          if (intElev > 0) {
            elevation += intElev;
          }
        }
        previousWpt = wpt;
      }
      distanceAndElevationLabel.setText(BigDecimal.valueOf(distance / 1000.0) + " km, " +
          BigDecimal.valueOf(elevation) + " Hm");
      centerAndScaleOnMap(findCentre(waypoints), findIdealZoomFactor(waypoints));
      drawRoute(waypoints);
    } catch (IOException | JAXBException e) {
      log.severe(e.getMessage());
    }
  }

  public void showElevationProfile(@Nonnull Comparable<?> key) {
    if (waypoints != null && !waypoints.isEmpty()) {
      createElevationProfileOverlay(key);
    }
  }

  private void initMap(String apiKey, String clientId) {
    googleMap = new GoogleMap(apiKey, clientId, "de");
    googleMap.setMapType(GoogleMap.MapType.ROADMAP);
    googleMap.setId("google-map");
    googleMap.setSizeFull();
    add(googleMap);
  }

  private void centerAndScaleOnMap(@Nonnull Pair<BigDecimal, BigDecimal> coordinates, @Nonnull BigDecimal zoom) {
    LatLon center = new LatLon(coordinates.getLeft().doubleValue(), coordinates.getRight().doubleValue());
    googleMap.setCenter(center);
    googleMap.setZoom(zoom.intValue());
  }

  private void drawRoute(@Nonnull List<WptType> waypoints) {
    GoogleMapPolygon routeOnMap = new GoogleMapPolygon(waypoints.stream()
        .map(wpt -> new LatLon(wpt.getLat().doubleValue(), wpt.getLon().doubleValue()))
        .map(GoogleMapPoint::new)
        .collect(Collectors.toList()));
    routeOnMap.setStrokeColor("#eb4034");
    routeOnMap.setClassName("RouteOnMap");
    googleMap.removeClassName("RouteOnMap");
    googleMap.addPolygon(routeOnMap);
  }

  @SuppressWarnings("UnusedReturnValue")
  @Nonnull
  private Dialog createElevationProfileOverlay(@Nonnull Comparable<?> key) {
    ElevationProfileOverlay elevationProfileOverlay = new ElevationProfileOverlay(waypoints, key);
    Dialog dialog = new Dialog();
    dialog.setWidth(OVERLAY_WIDTH_PX);
    dialog.setHeight((OVERLAY_WIDTH * OVERLAY_ASPECT_RATIO) + "px");
    dialog.add(elevationProfileOverlay);
    dialog.setCloseOnOutsideClick(true);
    dialog.setCloseOnEsc(true);
    dialog.setOpened(true);
    return dialog;
  }

  private void extractWaypoints(@Nonnull GpxType gpx) {
    waypoints = new ArrayList<>();
    gpx.getTrk()
        .forEach(trk -> trk.getTrkseg()
            .forEach(trkseg -> waypoints.addAll(trkseg.getTrkpt())));
  }
}
