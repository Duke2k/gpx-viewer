package de.duke2k.gpxviewer;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.function.SerializableConsumer;
import de.duke2k.gpxviewer.xjc.GpxType;
import de.duke2k.gpxviewer.xjc.WptType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.apache.commons.lang3.tuple.Pair;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;

import static java.lang.Math.PI;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

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
      Plot elevationPlot = new XYPlot();
      JFreeChart chart = new JFreeChart("Höhenprofil", elevationPlot);
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

  private void extractWaypoints(@Nonnull GpxType gpx) {
    waypoints = new ArrayList<>();
    gpx.getTrk()
        .forEach(trk -> trk.getTrkseg()
            .forEach(trkseg -> waypoints.addAll(trkseg.getTrkpt())));
  }

  @Nonnegative
  private double getDistance(double lat1, double lon1, double lat2, double lon2) {
    double earthRadius = 6371000.785;
    double dLat = deg2rad(lat2 - lat1);
    double dLon = deg2rad(lon2 - lon1);
    double a = sin(dLat / 2) * sin(dLat / 2) + cos(deg2rad(lat1)) * cos(deg2rad(lat2)) * sin(dLon / 2) * sin(dLon / 2);
    double c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return earthRadius * c;
  }

  @Nonnull
  private Pair<BigDecimal, BigDecimal> findCentre(@Nonnull Collection<WptType> waypoints) {
    double sumOfLats = waypoints.stream()
        .map(WptType::getLat)
        .mapToDouble(BigDecimal::doubleValue)
        .sum();
    double sumOfLons = waypoints.stream()
        .map(WptType::getLon)
        .mapToDouble(BigDecimal::doubleValue)
        .sum();
    return Pair.of(BigDecimal.valueOf(sumOfLats / waypoints.size()), BigDecimal.valueOf(sumOfLons / waypoints.size()));
  }

  @Nonnull
  private BigDecimal findIdealZoomFactor(@Nonnull Collection<WptType> waypoints) {
    double scaleLat = 0;
    OptionalDouble maxOfLats = waypoints.stream()
        .map(WptType::getLat)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::max);
    OptionalDouble minOfLats = waypoints.stream()
        .map(WptType::getLat)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::min);
    if (maxOfLats.isPresent() && minOfLats.isPresent()) {
      scaleLat = 180.0 / (maxOfLats.getAsDouble() - minOfLats.getAsDouble());
    }
    double scaleLon = 0;
    OptionalDouble maxOfLons = waypoints.stream()
        .map(WptType::getLon)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::max);
    OptionalDouble minOfLons = waypoints.stream()
        .map(WptType::getLon)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::min);
    if (maxOfLons.isPresent() && minOfLons.isPresent()) {
      scaleLon = 180 / maxOfLons.getAsDouble() - minOfLons.getAsDouble();
    }
    return BigDecimal.valueOf(Math.log((scaleLat + scaleLon) / 2) / Math.log(2));
  }

  private double deg2rad(double deg) {
    return deg * (PI / 180);
  }
}
