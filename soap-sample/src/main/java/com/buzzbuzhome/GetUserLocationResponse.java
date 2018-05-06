
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
 *         &lt;element name="GetUserLocationResult" type="{http://buzzbuzhome.com/}BBHLocation" minOccurs="0"/&gt;
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
    "getUserLocationResult"
})
@XmlRootElement(name = "GetUserLocationResponse")
public class GetUserLocationResponse {

    @XmlElement(name = "GetUserLocationResult")
    protected BBHLocation getUserLocationResult;

    /**
     * Gets the value of the getUserLocationResult property.
     * 
     * @return
     *     possible object is
     *     {@link BBHLocation }
     *     
     */
    public BBHLocation getGetUserLocationResult() {
        return getUserLocationResult;
    }

    /**
     * Sets the value of the getUserLocationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BBHLocation }
     *     
     */
    public void setGetUserLocationResult(BBHLocation value) {
        this.getUserLocationResult = value;
    }

}
