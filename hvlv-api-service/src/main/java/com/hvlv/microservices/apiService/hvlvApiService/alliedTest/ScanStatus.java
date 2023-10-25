/**
 * ScanStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class ScanStatus  implements java.io.Serializable {
    private java.lang.String consignmentNote;

    private java.lang.String depotLocation;

    private java.lang.String scannedBarcode;

    private java.lang.String scannedStatus;

    private java.util.Calendar scannnedTimestamp;

    public ScanStatus() {
    }

    public ScanStatus(
           java.lang.String consignmentNote,
           java.lang.String depotLocation,
           java.lang.String scannedBarcode,
           java.lang.String scannedStatus,
           java.util.Calendar scannnedTimestamp) {
           this.consignmentNote = consignmentNote;
           this.depotLocation = depotLocation;
           this.scannedBarcode = scannedBarcode;
           this.scannedStatus = scannedStatus;
           this.scannnedTimestamp = scannnedTimestamp;
    }


    /**
     * Gets the consignmentNote value for this ScanStatus.
     * 
     * @return consignmentNote
     */
    public java.lang.String getConsignmentNote() {
        return consignmentNote;
    }


    /**
     * Sets the consignmentNote value for this ScanStatus.
     * 
     * @param consignmentNote
     */
    public void setConsignmentNote(java.lang.String consignmentNote) {
        this.consignmentNote = consignmentNote;
    }


    /**
     * Gets the depotLocation value for this ScanStatus.
     * 
     * @return depotLocation
     */
    public java.lang.String getDepotLocation() {
        return depotLocation;
    }


    /**
     * Sets the depotLocation value for this ScanStatus.
     * 
     * @param depotLocation
     */
    public void setDepotLocation(java.lang.String depotLocation) {
        this.depotLocation = depotLocation;
    }


    /**
     * Gets the scannedBarcode value for this ScanStatus.
     * 
     * @return scannedBarcode
     */
    public java.lang.String getScannedBarcode() {
        return scannedBarcode;
    }


    /**
     * Sets the scannedBarcode value for this ScanStatus.
     * 
     * @param scannedBarcode
     */
    public void setScannedBarcode(java.lang.String scannedBarcode) {
        this.scannedBarcode = scannedBarcode;
    }


    /**
     * Gets the scannedStatus value for this ScanStatus.
     * 
     * @return scannedStatus
     */
    public java.lang.String getScannedStatus() {
        return scannedStatus;
    }


    /**
     * Sets the scannedStatus value for this ScanStatus.
     * 
     * @param scannedStatus
     */
    public void setScannedStatus(java.lang.String scannedStatus) {
        this.scannedStatus = scannedStatus;
    }


    /**
     * Gets the scannnedTimestamp value for this ScanStatus.
     * 
     * @return scannnedTimestamp
     */
    public java.util.Calendar getScannnedTimestamp() {
        return scannnedTimestamp;
    }


    /**
     * Sets the scannnedTimestamp value for this ScanStatus.
     * 
     * @param scannnedTimestamp
     */
    public void setScannnedTimestamp(java.util.Calendar scannnedTimestamp) {
        this.scannnedTimestamp = scannnedTimestamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ScanStatus)) return false;
        ScanStatus other = (ScanStatus) obj;
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
            ((this.depotLocation==null && other.getDepotLocation()==null) || 
             (this.depotLocation!=null &&
              this.depotLocation.equals(other.getDepotLocation()))) &&
            ((this.scannedBarcode==null && other.getScannedBarcode()==null) || 
             (this.scannedBarcode!=null &&
              this.scannedBarcode.equals(other.getScannedBarcode()))) &&
            ((this.scannedStatus==null && other.getScannedStatus()==null) || 
             (this.scannedStatus!=null &&
              this.scannedStatus.equals(other.getScannedStatus()))) &&
            ((this.scannnedTimestamp==null && other.getScannnedTimestamp()==null) || 
             (this.scannnedTimestamp!=null &&
              this.scannnedTimestamp.equals(other.getScannnedTimestamp())));
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
        if (getDepotLocation() != null) {
            _hashCode += getDepotLocation().hashCode();
        }
        if (getScannedBarcode() != null) {
            _hashCode += getScannedBarcode().hashCode();
        }
        if (getScannedStatus() != null) {
            _hashCode += getScannedStatus().hashCode();
        }
        if (getScannnedTimestamp() != null) {
            _hashCode += getScannnedTimestamp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScanStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ScanStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consignmentNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consignmentNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depotLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depotLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scannedBarcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scannedBarcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scannedStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scannedStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scannnedTimestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scannnedTimestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
