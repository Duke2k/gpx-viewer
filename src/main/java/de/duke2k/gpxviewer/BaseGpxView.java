package de.duke2k.gpxviewer;

import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.util.List;

@Route("gpx")
public class BaseGpxView extends VerticalLayout {

  @Autowired
  public BaseGpxView(List<File> availableGpxFiles, GpxView gpxView,
                     @Qualifier("distanceAndElevationLabel") Label distanceAndElevationLabel) {
    HorizontalLayout gpxSelector = new HorizontalLayout();
    Label availableRoutesLabel = new Label("Verfügbare Routen:");
    availableRoutesLabel.setWidth("300px");
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
    distanceAndElevationLabel.setWidth("600px");
    gpxSelector.add(availableRoutesLabel, availableGpxFilesComboBox, distanceAndElevationLabel, elevationProfileButton);
    gpxSelector.setWidthFull();
    add(gpxSelector, gpxView);
    setSizeFull();
  }
}
