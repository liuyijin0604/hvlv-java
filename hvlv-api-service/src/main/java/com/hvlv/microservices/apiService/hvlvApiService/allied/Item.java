/**
 * Item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class Item  implements java.io.Serializable {
    private boolean dangerous;

    private double height;

    private int itemCount;

    private double length;

    private double volume;

    private double weight;

    private double width;

    public Item() {
    }

    public Item(
           boolean dangerous,
           double height,
           int itemCount,
           double length,
           double volume,
           double weight,
           double width) {
           this.dangerous = dangerous;
           this.height = height;
           this.itemCount = itemCount;
           this.length = length;
           this.volume = volume;
           this.weight = weight;
           this.width = width;
    }


    /**
     * Gets the dangerous value for this Item.
     * 
     * @return dangerous
     */
    public boolean isDangerous() {
        return dangerous;
    }


    /**
     * Sets the dangerous value for this Item.
     * 
     * @param dangerous
     */
    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }


    /**
     * Gets the height value for this Item.
     * 
     * @return height
     */
    public double getHeight() {
        return height;
    }


    /**
     * Sets the height value for this Item.
     * 
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }


    /**
     * Gets the itemCount value for this Item.
     * 
     * @return itemCount
     */
    public int getItemCount() {
        return itemCount;
    }


    /**
     * Sets the itemCount value for this Item.
     * 
     * @param itemCount
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }


    /**
     * Gets the length value for this Item.
     * 
     * @return length
     */
    public double getLength() {
        return length;
    }


    /**
     * Sets the length value for this Item.
     * 
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }


    /**
     * Gets the volume value for this Item.
     * 
     * @return volume
     */
    public double getVolume() {
        return volume;
    }


    /**
     * Sets the volume value for this Item.
     * 
     * @param volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }


    /**
     * Gets the weight value for this Item.
     * 
     * @return weight
     */
    public double getWeight() {
        return weight;
    }


    /**
     * Sets the weight value for this Item.
     * 
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }


    /**
     * Gets the width value for this Item.
     * 
     * @return width
     */
    public double getWidth() {
        return width;
    }


    /**
     * Sets the width value for this Item.
     * 
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.dangerous == other.isDangerous() &&
            this.height == other.getHeight() &&
            this.itemCount == other.getItemCount() &&
            this.length == other.getLength() &&
            this.volume == other.getVolume() &&
            this.weight == other.getWeight() &&
            this.width == other.getWidth();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isDangerous() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Double(getHeight()).hashCode();
        _hashCode += getItemCount();
        _hashCode += new Double(getLength()).hashCode();
        _hashCode += new Double(getVolume()).hashCode();
        _hashCode += new Double(getWeight()).hashCode();
        _hashCode += new Double(getWidth()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Item"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dangerous");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dangerous"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("height");
        elemField.setXmlName(new javax.xml.namespace.QName("", "height"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volume");
        elemField.setXmlName(new javax.xml.namespace.QName("", "volume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "weight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("width");
        elemField.setXmlName(new javax.xml.namespace.QName("", "width"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
