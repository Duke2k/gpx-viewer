package de.duke2k.gpxviewer;

import de.duke2k.gpxviewer.xjc.GpxType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class BeanConfiguration {

  @Bean
  public JAXBContext jaxbContext() throws JAXBException {
    return JAXBContext.newInstance(GpxType.class);
  }

  @Bean
  public List<File> availableGpxFiles()
      throws URISyntaxException, IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource("gpx");
    if (resource != null) {
      try (Stream<Path> paths = Files.walk(Paths.get(resource.toURI()))) {
        return paths
            .filter(Files::isRegularFile)
            .map(Path::toFile)
            .collect(Collectors.toList());
      }
    }
    return Collections.emptyList();
  }
}
