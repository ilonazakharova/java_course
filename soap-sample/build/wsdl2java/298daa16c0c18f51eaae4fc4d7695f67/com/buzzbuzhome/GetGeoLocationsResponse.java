
package com.buzzbuzhome;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetGeoLocationsResult" type="{http://buzzbuzhome.com/}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getGeoLocationsResult"
})
@XmlRootElement(name = "GetGeoLocationsResponse")
public class GetGeoLocationsResponse {

    @XmlElement(name = "GetGeoLocationsResult")
    protected ArrayOfString getGeoLocationsResult;

    /**
     * Gets the value of the getGeoLocationsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetGeoLocationsResult() {
        return getGeoLocationsResult;
    }

    /**
     * Sets the value of the getGeoLocationsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetGeoLocationsResult(ArrayOfString value) {
        this.getGeoLocationsResult = value;
    }

}
