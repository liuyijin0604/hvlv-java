/**
 * ShipmentStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class ShipmentStatus  implements java.io.Serializable {
    private ScanStatus[] statusBarcodesList;

    private java.lang.String statusError;

    public ShipmentStatus() {
    }

    public ShipmentStatus(
           ScanStatus[] statusBarcodesList,
           java.lang.String statusError) {
           this.statusBarcodesList = statusBarcodesList;
           this.statusError = statusError;
    }


    /**
     * Gets the statusBarcodesList value for this ShipmentStatus.
     * 
     * @return statusBarcodesList
     */
    public ScanStatus[] getStatusBarcodesList() {
        return statusBarcodesList;
    }


    /**
     * Sets the statusBarcodesList value for this ShipmentStatus.
     * 
     * @param statusBarcodesList
     */
    public void setStatusBarcodesList(ScanStatus[] statusBarcodesList) {
        this.statusBarcodesList = statusBarcodesList;
    }

    public ScanStatus getStatusBarcodesList(int i) {
        return this.statusBarcodesList[i];
    }

    public void setStatusBarcodesList(int i, ScanStatus _value) {
        this.statusBarcodesList[i] = _value;
    }


    /**
     * Gets the statusError value for this ShipmentStatus.
     * 
     * @return statusError
     */
    public java.lang.String getStatusError() {
        return statusError;
    }


    /**
     * Sets the statusError value for this ShipmentStatus.
     * 
     * @param statusError
     */
    public void setStatusError(java.lang.String statusError) {
        this.statusError = statusError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ShipmentStatus)) return false;
        ShipmentStatus other = (ShipmentStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.statusBarcodesList==null && other.getStatusBarcodesList()==null) || 
             (this.statusBarcodesList!=null &&
              java.util.Arrays.equals(this.statusBarcodesList, other.getStatusBarcodesList()))) &&
            ((this.statusError==null && other.getStatusError()==null) || 
             (this.statusError!=null &&
              this.statusError.equals(other.getStatusError())));
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
        if (getStatusBarcodesList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStatusBarcodesList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStatusBarcodesList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatusError() != null) {
            _hashCode += getStatusError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ShipmentStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ShipmentStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusBarcodesList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusBarcodesList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ScanStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusError"));
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
