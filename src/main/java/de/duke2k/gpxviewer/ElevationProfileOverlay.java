package de.duke2k.gpxviewer;

import com.vaadin.flow.component.html.Div;
import de.duke2k.gpxviewer.xjc.WptType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

public class ElevationProfileOverlay extends Div {

  private final List<WptType> waypoints;
  private final Comparable<?> key;

  public ElevationProfileOverlay(List<WptType> waypoints, Comparable<?> key) {
    this.waypoints = waypoints;
    this.key = key;
    createElevationProfileChart();
    setSizeFull();
  }

  private void createElevationProfileChart() {
    var series = new XYSeries(key);
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);
    JFreeChart chart = ChartFactory.createXYLineChart(
        "Höhenprofil",
        "Entfernung (km)",
        "Höhe (m)",
        dataset,
        PlotOrientation.HORIZONTAL,
        true,
        true,
        false
    );
  }
}
