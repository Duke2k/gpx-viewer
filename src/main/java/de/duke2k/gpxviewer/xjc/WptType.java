//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.2 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.01.02 um 12:24:04 PM CET 
//


package de.duke2k.gpxviewer.xjc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 *         wpt represents a waypoint, point of interest, or named feature on a map.
 *       
 * 
 * <p>Java-Klasse für wptType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="wptType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ele" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="magvar" type="{http://www.topografix.com/GPX/1/1}degreesType" minOccurs="0"/&gt;
 *         &lt;element name="geoidheight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="src" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="link" type="{http://www.topografix.com/GPX/1/1}linkType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="sym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fix" type="{http://www.topografix.com/GPX/1/1}fixType" minOccurs="0"/&gt;
 *         &lt;element name="sat" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *         &lt;element name="hdop" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="vdop" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="pdop" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ageofdgpsdata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="dgpsid" type="{http://www.topografix.com/GPX/1/1}dgpsStationType" minOccurs="0"/&gt;
 *         &lt;element name="extensions" type="{http://www.topografix.com/GPX/1/1}extensionsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="lat" use="required" type="{http://www.topografix.com/GPX/1/1}latitudeType" /&gt;
 *       &lt;attribute name="lon" use="required" type="{http://www.topografix.com/GPX/1/1}longitudeType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wptType", namespace = "http://www.topografix.com/GPX/1/1", propOrder = {
    "ele",
    "time",
    "magvar",
    "geoidheight",
    "name",
    "cmt",
    "desc",
    "src",
    "link",
    "sym",
    "type",
    "fix",
    "sat",
    "hdop",
    "vdop",
    "pdop",
    "ageofdgpsdata",
    "dgpsid",
    "extensions"
})
public class WptType {

    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal ele;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar time;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal magvar;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal geoidheight;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String name;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String cmt;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String desc;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String src;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected List<LinkType> link;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String sym;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String type;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected String fix;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger sat;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal hdop;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal vdop;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal pdop;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected BigDecimal ageofdgpsdata;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    @XmlSchemaType(name = "integer")
    protected Integer dgpsid;
    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected ExtensionsType extensions;
    @XmlAttribute(name = "lat", required = true)
    protected BigDecimal lat;
    @XmlAttribute(name = "lon", required = true)
    protected BigDecimal lon;

    /**
     * Ruft den Wert der ele-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEle() {
        return ele;
    }

    /**
     * Legt den Wert der ele-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEle(BigDecimal value) {
        this.ele = value;
    }

    /**
     * Ruft den Wert der time-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Legt den Wert der time-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Ruft den Wert der magvar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMagvar() {
        return magvar;
    }

    /**
     * Legt den Wert der magvar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMagvar(BigDecimal value) {
        this.magvar = value;
    }

    /**
     * Ruft den Wert der geoidheight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGeoidheight() {
        return geoidheight;
    }

    /**
     * Legt den Wert der geoidheight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGeoidheight(BigDecimal value) {
        this.geoidheight = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der cmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmt() {
        return cmt;
    }

    /**
     * Legt den Wert der cmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmt(String value) {
        this.cmt = value;
    }

    /**
     * Ruft den Wert der desc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Legt den Wert der desc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Ruft den Wert der src-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Legt den Wert der src-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the link property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkType }
     * 
     * 
     */
    public List<LinkType> getLink() {
        if (link == null) {
            link = new ArrayList<LinkType>();
        }
        return this.link;
    }

    /**
     * Ruft den Wert der sym-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSym() {
        return sym;
    }

    /**
     * Legt den Wert der sym-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSym(String value) {
        this.sym = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der fix-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFix() {
        return fix;
    }

    /**
     * Legt den Wert der fix-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFix(String value) {
        this.fix = value;
    }

    /**
     * Ruft den Wert der sat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSat() {
        return sat;
    }

    /**
     * Legt den Wert der sat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSat(BigInteger value) {
        this.sat = value;
    }

    /**
     * Ruft den Wert der hdop-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHdop() {
        return hdop;
    }

    /**
     * Legt den Wert der hdop-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHdop(BigDecimal value) {
        this.hdop = value;
    }

    /**
     * Ruft den Wert der vdop-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVdop() {
        return vdop;
    }

    /**
     * Legt den Wert der vdop-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVdop(BigDecimal value) {
        this.vdop = value;
    }

    /**
     * Ruft den Wert der pdop-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPdop() {
        return pdop;
    }

    /**
     * Legt den Wert der pdop-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPdop(BigDecimal value) {
        this.pdop = value;
    }

    /**
     * Ruft den Wert der ageofdgpsdata-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAgeofdgpsdata() {
        return ageofdgpsdata;
    }

    /**
     * Legt den Wert der ageofdgpsdata-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAgeofdgpsdata(BigDecimal value) {
        this.ageofdgpsdata = value;
    }

    /**
     * Ruft den Wert der dgpsid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDgpsid() {
        return dgpsid;
    }

    /**
     * Legt den Wert der dgpsid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDgpsid(Integer value) {
        this.dgpsid = value;
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
     * Ruft den Wert der lat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * Legt den Wert der lat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLat(BigDecimal value) {
        this.lat = value;
    }

    /**
     * Ruft den Wert der lon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLon() {
        return lon;
    }

    /**
     * Legt den Wert der lon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLon(BigDecimal value) {
        this.lon = value;
    }

}
