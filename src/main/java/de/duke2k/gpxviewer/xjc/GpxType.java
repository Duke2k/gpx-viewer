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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 *         GPX documents contain a metadata header, followed by waypoints, routes, and tracks. You can add your own
 *         elements to the extensions section of the GPX document.
 *       
 * 
 * <p>Java-Klasse für gpxType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="gpxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="metadata" type="{http://www.topografix.com/GPX/1/1}metadataType" minOccurs="0"/&gt;
 *         &lt;element name="wpt" type="{http://www.topografix.com/GPX/1/1}wptType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="rte" type="{http://www.topografix.com/GPX/1/1}rteType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="trk" type="{http://www.topografix.com/GPX/1/1}trkType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="extensions" type="{http://www.topografix.com/GPX/1/1}extensionsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="1.1" /&gt;
 *       &lt;attribute name="creator" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gpxType", namespace = "http://www.topografix.com/GPX/1/1", propOrder = {
    "metadata",
    "wpt",
    "rte",
    "trk",
    "extensions"
})
public class GpxType {

    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected MetadataType metadata;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected List<WptType> wpt;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected List<RteType> rte;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected List<TrkType> trk;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected ExtensionsType extensions;
    @XmlAttribute(name = "version", required = true)
    protected String version;
    @XmlAttribute(name = "creator", required = true)
    protected String creator;

    /**
     * Ruft den Wert der metadata-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MetadataType }
     *     
     */
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Legt den Wert der metadata-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     *     
     */
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the wpt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the wpt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWpt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WptType }
     * 
     * 
     */
    public List<WptType> getWpt() {
        if (wpt == null) {
            wpt = new ArrayList<WptType>();
        }
        return this.wpt;
    }

    /**
     * Gets the value of the rte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the rte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RteType }
     * 
     * 
     */
    public List<RteType> getRte() {
        if (rte == null) {
            rte = new ArrayList<RteType>();
        }
        return this.rte;
    }

    /**
     * Gets the value of the trk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the trk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrkType }
     * 
     * 
     */
    public List<TrkType> getTrk() {
        if (trk == null) {
            trk = new ArrayList<TrkType>();
        }
        return this.trk;
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

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.1";
        } else {
            return version;
        }
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Ruft den Wert der creator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Legt den Wert der creator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

}
