//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.01 at 02:53:28 AM CEST 
//


package me.antoniocaccamo.player.rx.model.legacy.sequences;


import me.antoniocaccamo.player.rx.model.legacy.JaxbAstratModel;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for videoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="videoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="path" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="to" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="daysOfWeek" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="remotePath" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="limited" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="group" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="type" type="{http://sequencemovieplayer.antanysavage.it/sequences/schema}acceptedVideoTypes" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "videoType")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
public class VideoType extends JaxbAstratModel {

    @XmlAttribute(name = "id")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected BigInteger id;
    @XmlAttribute(name = "path")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String path;
    @XmlAttribute(name = "duration")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected Float duration;
    @XmlAttribute(name = "start")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String start;
    @XmlAttribute(name = "end")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String end;
    @XmlAttribute(name = "from")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String from;
    @XmlAttribute(name = "to")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String to;
    @XmlAttribute(name = "daysOfWeek")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String daysOfWeek;
    @XmlAttribute(name = "remotePath")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String remotePath;
    @XmlAttribute(name = "limited")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected Integer limited;
    @XmlAttribute(name = "group")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected String group;
    @XmlAttribute(name = "type")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    protected AcceptedVideoTypes type;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public Float getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setDuration(Float value) {
        this.duration = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setStart(String value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setEnd(String value) {
        this.end = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Gets the value of the daysOfWeek property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * Sets the value of the daysOfWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setDaysOfWeek(String value) {
        this.daysOfWeek = value;
    }

    /**
     * Gets the value of the remotePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getRemotePath() {
        return remotePath;
    }

    /**
     * Sets the value of the remotePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setRemotePath(String value) {
        this.remotePath = value;
    }

    /**
     * Gets the value of the limited property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public Integer getLimited() {
        return limited;
    }

    /**
     * Sets the value of the limited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setLimited(Integer value) {
        this.limited = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public String getGroup() {
        if (group == null) {
            return "";
        } else {
            return group;
        }
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AcceptedVideoTypes }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public AcceptedVideoTypes getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcceptedVideoTypes }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-05-01T02:53:28+02:00", comments = "JAXB RI v2.3.0")
    public void setType(AcceptedVideoTypes value) {
        this.type = value;
    }

    /*
     * ------------------------------------------------------------------------
     *
     * ------------------------------------------------------------------------
     */
    @Override
    public void postConstruct() throws Exception {

    }

}