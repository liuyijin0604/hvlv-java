/**
 * POD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class POD  implements java.io.Serializable {
    private java.lang.String consignmentNote;

    private byte[] podData;

    public POD() {
    }

    public POD(
           java.lang.String consignmentNote,
           byte[] podData) {
           this.consignmentNote = consignmentNote;
           this.podData = podData;
    }


    /**
     * Gets the consignmentNote value for this POD.
     * 
     * @return consignmentNote
     */
    public java.lang.String getConsignmentNote() {
        return consignmentNote;
    }


    /**
     * Sets the consignmentNote value for this POD.
     * 
     * @param consignmentNote
     */
    public void setConsignmentNote(java.lang.String consignmentNote) {
        this.consignmentNote = consignmentNote;
    }


    /**
     * Gets the podData value for this POD.
     * 
     * @return podData
     */
    public byte[] getPodData() {
        return podData;
    }


    /**
     * Sets the podData value for this POD.
     * 
     * @param podData
     */
    public void setPodData(byte[] podData) {
        this.podData = podData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POD)) return false;
        POD other = (POD) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consignmentNote==null && other.getConsignmentNote()==null) || 
             (this.consignmentNote!=null &&
              this.consignmentNote.equals(other.getConsignmentNote()))) &&
            ((this.podData==null && other.getPodData()==null) || 
             (this.podData!=null &&
              java.util.Arrays.equals(this.podData, other.getPodData())));
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
        if (getConsignmentNote() != null) {
            _hashCode += getConsignmentNote().hashCode();
        }
        if (getPodData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPodData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPodData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "POD"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consignmentNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consignmentNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("podData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "podData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
