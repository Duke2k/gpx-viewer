package de.duke2k.gpxviewer;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.BootstrapListener;
import com.vaadin.flow.server.BootstrapPageResponse;
import lombok.extern.java.Log;

@Log
public class MainLayout extends HorizontalLayout implements RouterLayout, BootstrapListener {

  @Override
  public void modifyBootstrapPage(BootstrapPageResponse response) {
  }
}
