/**
 * ElectronicSignature.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class ElectronicSignature  implements java.io.Serializable {
    private java.lang.String docketNumber;

    private java.lang.String recipientName;

    private byte[] signatureImage;

    public ElectronicSignature() {
    }

    public ElectronicSignature(
           java.lang.String docketNumber,
           java.lang.String recipientName,
           byte[] signatureImage) {
           this.docketNumber = docketNumber;
           this.recipientName = recipientName;
           this.signatureImage = signatureImage;
    }


    /**
     * Gets the docketNumber value for this ElectronicSignature.
     * 
     * @return docketNumber
     */
    public java.lang.String getDocketNumber() {
        return docketNumber;
    }


    /**
     * Sets the docketNumber value for this ElectronicSignature.
     * 
     * @param docketNumber
     */
    public void setDocketNumber(java.lang.String docketNumber) {
        this.docketNumber = docketNumber;
    }


    /**
     * Gets the recipientName value for this ElectronicSignature.
     * 
     * @return recipientName
     */
    public java.lang.String getRecipientName() {
        return recipientName;
    }


    /**
     * Sets the recipientName value for this ElectronicSignature.
     * 
     * @param recipientName
     */
    public void setRecipientName(java.lang.String recipientName) {
        this.recipientName = recipientName;
    }


    /**
     * Gets the signatureImage value for this ElectronicSignature.
     * 
     * @return signatureImage
     */
    public byte[] getSignatureImage() {
        return signatureImage;
    }


    /**
     * Sets the signatureImage value for this ElectronicSignature.
     * 
     * @param signatureImage
     */
    public void setSignatureImage(byte[] signatureImage) {
        this.signatureImage = signatureImage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ElectronicSignature)) return false;
        ElectronicSignature other = (ElectronicSignature) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.docketNumber==null && other.getDocketNumber()==null) || 
             (this.docketNumber!=null &&
              this.docketNumber.equals(other.getDocketNumber()))) &&
            ((this.recipientName==null && other.getRecipientName()==null) || 
             (this.recipientName!=null &&
              this.recipientName.equals(other.getRecipientName()))) &&
            ((this.signatureImage==null && other.getSignatureImage()==null) || 
             (this.signatureImage!=null &&
              java.util.Arrays.equals(this.signatureImage, other.getSignatureImage())));
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
        if (getDocketNumber() != null) {
            _hashCode += getDocketNumber().hashCode();
        }
        if (getRecipientName() != null) {
            _hashCode += getRecipientName().hashCode();
        }
        if (getSignatureImage() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignatureImage());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignatureImage(), i);
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
        new org.apache.axis.description.TypeDesc(ElectronicSignature.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ElectronicSignature"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docketNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "docketNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipientName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recipientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signatureImage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signatureImage"));
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
