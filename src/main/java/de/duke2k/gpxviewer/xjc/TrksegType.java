//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.2 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.01.02 um 12:24:04 PM CET 
//


package de.duke2k.gpxviewer.xjc;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 *         A Track Segment holds a list of Track Points which are logically connected in order. To represent a single GPS
 *         track where GPS reception was lost, or the GPS receiver was turned off, start a new Track Segment for each
 *         continuous span of track data.
 *       
 * 
 * <p>Java-Klasse für trksegType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="trksegType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="trkpt" type="{http://www.topografix.com/GPX/1/1}wptType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="extensions" type="{http://www.topografix.com/GPX/1/1}extensionsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trksegType", namespace = "http://www.topografix.com/GPX/1/1", propOrder = {
    "trkpt",
    "extensions"
})
public class TrksegType {

    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected List<WptType> trkpt;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected ExtensionsType extensions;

    /**
     * Gets the value of the trkpt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the trkpt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrkpt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WptType }
     * 
     * 
     */
    public List<WptType> getTrkpt() {
        if (trkpt == null) {
            trkpt = new ArrayList<WptType>();
        }
        return this.trkpt;
    }

    /**
     * Ruft den Wert der extensions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionsType }
     *     
     */
    public ExtensionsType getExtensions() {
        return extensions;
    }

    /**
     * Legt den Wert der extensions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionsType }
     *     
     */
    public void setExtensions(ExtensionsType value) {
        this.extensions = value;
    }

}
