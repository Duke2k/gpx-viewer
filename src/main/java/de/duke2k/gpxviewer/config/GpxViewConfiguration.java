package de.duke2k.gpxviewer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "gpx-viewer.google-maps")
public class GpxViewConfiguration {

  @Setter
  private String apiKey;

  @Setter
  private String clientId;
}
