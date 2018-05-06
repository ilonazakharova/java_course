
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
 *         &lt;element name="GetLocationsResult" type="{http://buzzbuzhome.com/}ArrayOfBBHLocation" minOccurs="0"/&gt;
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
    "getLocationsResult"
})
@XmlRootElement(name = "GetLocationsResponse")
public class GetLocationsResponse {

    @XmlElement(name = "GetLocationsResult")
    protected ArrayOfBBHLocation getLocationsResult;

    /**
     * Gets the value of the getLocationsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBBHLocation }
     *     
     */
    public ArrayOfBBHLocation getGetLocationsResult() {
        return getLocationsResult;
    }

    /**
     * Sets the value of the getLocationsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBBHLocation }
     *     
     */
    public void setGetLocationsResult(ArrayOfBBHLocation value) {
        this.getLocationsResult = value;
    }

}
