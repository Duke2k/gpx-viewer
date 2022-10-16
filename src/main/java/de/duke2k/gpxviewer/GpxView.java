package de.duke2k.gpxviewer;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.function.SerializableConsumer;
import de.duke2k.gpxviewer.xjc.GpxType;
import de.duke2k.gpxviewer.xjc.WptType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_ASPECT_RATIO;
import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_WIDTH;
import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_WIDTH_PX;
import static de.duke2k.gpxviewer.util.GpxUtils.findCentre;
import static de.duke2k.gpxviewer.util.GpxUtils.findIdealZoomFactor;
import static de.duke2k.gpxviewer.util.GpxUtils.getDistance;

@Log
@NpmPackage(value = "ol", version = "7.1.0")
@CssImport("ol/ol.css")
@JsModule("./src/openlayers-connector.js")
public class GpxView extends Div {

  private final GpxReader gpxReader;
  private final Label distanceAndElevationLabel;
  private List<WptType> waypoints;

  public GpxView(GpxReader gpxReader, Label distanceAndElevationLabel) {
    this.gpxReader = gpxReader;
    this.distanceAndElevationLabel = distanceAndElevationLabel;
    initConnector();
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
      centerAndScale(findCentre(waypoints), findIdealZoomFactor(waypoints));
    } catch (IOException | JAXBException e) {
      log.severe(e.getMessage());
    }
  }

  public void showElevationProfile() {
    if (waypoints != null && !waypoints.isEmpty()) {
      createElevationProfileOverlay();
    }
  }

  private void initConnector() {
    runBeforeClientResponse(ui -> ui.getPage().executeJs(
        "window.Vaadin.Flow.openLayersConnector.initLazy($0)",
        getElement()));
  }

  private void centerAndScale(Pair<BigDecimal, BigDecimal> coordinates, BigDecimal zoom) {
    UI.getCurrent().getPage().executeJs(
        "window.Vaadin.Flow.openLayersConnector.centerAndScale($0, $1, $2, $3)",
        getElement(), coordinates.getLeft().doubleValue(), coordinates.getRight().doubleValue(), zoom.doubleValue());
  }

  private void runBeforeClientResponse(SerializableConsumer<UI> command) {
    getElement().getNode().runWhenAttached(ui -> ui
        .beforeClientResponse(this, context -> command.accept(ui)));
  }

  @SuppressWarnings("UnusedReturnValue")
  @Nonnull
  private Dialog createElevationProfileOverlay() {
    ElevationProfileOverlay elevationProfileOverlay = new ElevationProfileOverlay(waypoints);
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
