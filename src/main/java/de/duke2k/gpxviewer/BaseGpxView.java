package de.duke2k.gpxviewer;

import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

@Route("gpx")
public class BaseGpxView extends VerticalLayout {

  @Autowired
  public BaseGpxView(List<File> availableGpxFiles, GpxReader gpxReader) {
    HorizontalLayout gpxSelector = new HorizontalLayout();
    NativeLabel availableRoutesLabel = new NativeLabel("Verfügbare Routen:");
    availableRoutesLabel.setWidth("300px");
    NativeLabel distanceAndElevationLabel = new NativeLabel("0 km, 0 Hm");
    distanceAndElevationLabel.setWidth("600px");
    GpxView gpxView = new GpxView(gpxReader, distanceAndElevationLabel);
    gpxView.setId("map");
    gpxView.setSizeFull();
    ComboBox<File> availableGpxFilesComboBox = new ComboBox<>();
    availableGpxFilesComboBox.setItems(availableGpxFiles);
    availableGpxFilesComboBox.setItemLabelGenerator((ItemLabelGenerator<File>) File::getName);
    Button elevationProfileButton = new Button("Höhenprofil");
    elevationProfileButton.setEnabled(false);
    elevationProfileButton.setIcon(VaadinIcon.CHART_LINE.create());
    elevationProfileButton.addClickListener(event -> gpxView.showElevationProfile("Segment"));
    availableGpxFilesComboBox.addValueChangeListener(event -> {
      gpxView.loadGpxRoute(event.getValue());
      elevationProfileButton.setEnabled(true);
    });
    availableGpxFilesComboBox.setWidthFull();
    gpxSelector.add(availableRoutesLabel, availableGpxFilesComboBox, distanceAndElevationLabel, elevationProfileButton);
    gpxSelector.setWidthFull();
    add(gpxSelector, gpxView);
    setSizeFull();
  }
}
