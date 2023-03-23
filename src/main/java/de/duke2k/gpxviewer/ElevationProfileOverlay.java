package de.duke2k.gpxviewer;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;
import de.duke2k.gpxviewer.xjc.WptType;
import lombok.extern.java.Log;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_ASPECT_RATIO;
import static de.duke2k.gpxviewer.VaadinConstants.OVERLAY_WIDTH;
import static de.duke2k.gpxviewer.util.GpxUtils.getDistance;

@Log
public class ElevationProfileOverlay extends Div {

  public ElevationProfileOverlay(@Nonnull List<WptType> wpts, @Nonnull Comparable<?> key) {
    createElevationProfileChart(wpts, key);
    setSizeFull();
    setId("elevationProfile");
  }

  private void createElevationProfileChart(@Nonnull List<WptType> wpts, @Nonnull Comparable<?> key) {
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(createXYSeries(wpts, key));
    JFreeChart chart = ChartFactory.createXYLineChart("Höhenprofil", "Entfernung (km)",
        "Höhe (m)", dataset);
    BufferedImage bufferedImage = chart.createBufferedImage(OVERLAY_WIDTH, Math.round(OVERLAY_WIDTH * OVERLAY_ASPECT_RATIO));
    StreamResource streamResource = new StreamResource("elevationProfileResource", () -> {
      try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
        ImageIO.write(bufferedImage, "png", outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
      } catch (IOException e) {
        log.severe(e.getMessage());
      }
      return new ByteArrayInputStream(new byte[0]);
    });
    Image chartImage = new Image(streamResource, "Höhenprofil");
    add(chartImage);
    chartImage.setSizeFull();
  }

  private XYSeries createXYSeries(@Nonnull List<WptType> wpts, @Nonnull Comparable<?> key) {
    XYSeries result = new XYSeries(key);
    double distance = 0.0;
    WptType previousWpt = null;
    for (WptType wpt : wpts) {
      if (previousWpt != null) {
        distance += getDistance(previousWpt.getLat().doubleValue(), previousWpt.getLon().doubleValue(),
            wpt.getLat().doubleValue(), wpt.getLon().doubleValue());
      }
      result.add(distance, wpt.getEle().doubleValue());
      previousWpt = wpt;
    }
    return result;
  }
}
