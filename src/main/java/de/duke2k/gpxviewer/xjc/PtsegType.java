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
 *         An ordered sequence of points. (for polygons or polylines, e.g.)
 *       
 * 
 * <p>Java-Klasse für ptsegType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ptsegType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pt" type="{http://www.topografix.com/GPX/1/1}ptType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ptsegType", namespace = "http://www.topografix.com/GPX/1/1", propOrder = {
    "pt"
})
public class PtsegType {

    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    protected List<PtType> pt;

    /**
     * Gets the value of the pt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the pt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PtType }
     * 
     * 
     */
    public List<PtType> getPt() {
        if (pt == null) {
            pt = new ArrayList<PtType>();
        }
        return this.pt;
    }

}
