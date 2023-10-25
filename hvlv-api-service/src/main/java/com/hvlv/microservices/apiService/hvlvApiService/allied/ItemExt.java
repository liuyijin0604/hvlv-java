/**
 * ItemExt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class ItemExt  implements java.io.Serializable {
    private com.hvlv.microservices.apiService.hvlvApiService.allied.Item item;

    private java.lang.String itemCode;

    private java.lang.String itemDesciption;

    private java.lang.String itemReference;

    public ItemExt() {
    }

    public ItemExt(
           com.hvlv.microservices.apiService.hvlvApiService.allied.Item item,
           java.lang.String itemCode,
           java.lang.String itemDesciption,
           java.lang.String itemReference) {
           this.item = item;
           this.itemCode = itemCode;
           this.itemDesciption = itemDesciption;
           this.itemReference = itemReference;
    }


    /**
     * Gets the item value for this ItemExt.
     * 
     * @return item
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Item getItem() {
        return item;
    }


    /**
     * Sets the item value for this ItemExt.
     * 
     * @param item
     */
    public void setItem(com.hvlv.microservices.apiService.hvlvApiService.allied.Item item) {
        this.item = item;
    }


    /**
     * Gets the itemCode value for this ItemExt.
     * 
     * @return itemCode
     */
    public java.lang.String getItemCode() {
        return itemCode;
    }


    /**
     * Sets the itemCode value for this ItemExt.
     * 
     * @param itemCode
     */
    public void setItemCode(java.lang.String itemCode) {
        this.itemCode = itemCode;
    }


    /**
     * Gets the itemDesciption value for this ItemExt.
     * 
     * @return itemDesciption
     */
    public java.lang.String getItemDesciption() {
        return itemDesciption;
    }


    /**
     * Sets the itemDesciption value for this ItemExt.
     * 
     * @param itemDesciption
     */
    public void setItemDesciption(java.lang.String itemDesciption) {
        this.itemDesciption = itemDesciption;
    }


    /**
     * Gets the itemReference value for this ItemExt.
     * 
     * @return itemReference
     */
    public java.lang.String getItemReference() {
        return itemReference;
    }


    /**
     * Sets the itemReference value for this ItemExt.
     * 
     * @param itemReference
     */
    public void setItemReference(java.lang.String itemReference) {
        this.itemReference = itemReference;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemExt)) return false;
        ItemExt other = (ItemExt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.item==null && other.getItem()==null) || 
             (this.item!=null &&
              this.item.equals(other.getItem()))) &&
            ((this.itemCode==null && other.getItemCode()==null) || 
             (this.itemCode!=null &&
              this.itemCode.equals(other.getItemCode()))) &&
            ((this.itemDesciption==null && other.getItemDesciption()==null) || 
             (this.itemDesciption!=null &&
              this.itemDesciption.equals(other.getItemDesciption()))) &&
            ((this.itemReference==null && other.getItemReference()==null) || 
             (this.itemReference!=null &&
              this.itemReference.equals(other.getItemReference())));
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
        if (getItem() != null) {
            _hashCode += getItem().hashCode();
        }
        if (getItemCode() != null) {
            _hashCode += getItemCode().hashCode();
        }
        if (getItemDesciption() != null) {
            _hashCode += getItemDesciption().hashCode();
        }
        if (getItemReference() != null) {
            _hashCode += getItemReference().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemExt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ItemExt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item");
        elemField.setXmlName(new javax.xml.namespace.QName("", "item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Item"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemDesciption");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemDesciption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemReference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
