package de.duke2k.gpxviewer;

import de.duke2k.gpxviewer.xjc.GpxType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component
public class GpxReader {

  private final Unmarshaller unmarshaller;

  @Autowired
  public GpxReader(JAXBContext jaxbContext) throws JAXBException {
    unmarshaller = jaxbContext.createUnmarshaller();
  }

  @Nonnull
  public JAXBElement<GpxType> readFromFile(@Nonnull File gpxFile) throws IOException, JAXBException {
    try (InputStream inputStream = new FileInputStream(gpxFile)) {
      return readFromXml(IOUtils.toString(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8));
    }
  }

  @Nonnull
  public JAXBElement<GpxType> readFromXml(String xml) throws JAXBException {
    try (StringReader stringReader = new StringReader(xml)) {
      //noinspection unchecked
      return (JAXBElement<GpxType>) unmarshaller.unmarshal(stringReader);
    }
  }
}
