package de.duke2k.gpxviewer;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class EntryView extends Div implements BeforeEnterObserver {

  private final Class<? extends Component> firstView;

  @Autowired
  public EntryView() {
    firstView = BaseGpxView.class;
  }

  @Override
  public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
    beforeEnterEvent.forwardTo(firstView);
  }
}
