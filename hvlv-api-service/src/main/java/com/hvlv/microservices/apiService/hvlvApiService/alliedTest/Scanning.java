/**
 * Scanning.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class Scanning  implements java.io.Serializable {
    private java.lang.String batchID;

    private java.lang.String consignmentNote;

    private java.lang.String consignmentPart;

    private java.lang.String driverNum;

    private java.lang.String location;

    private java.util.Calendar scanDate;

    private java.lang.String userID;

    public Scanning() {
    }

    public Scanning(
           java.lang.String batchID,
           java.lang.String consignmentNote,
           java.lang.String consignmentPart,
           java.lang.String driverNum,
           java.lang.String location,
           java.util.Calendar scanDate,
           java.lang.String userID) {
           this.batchID = batchID;
           this.consignmentNote = consignmentNote;
           this.consignmentPart = consignmentPart;
           this.driverNum = driverNum;
           this.location = location;
           this.scanDate = scanDate;
           this.userID = userID;
    }


    /**
     * Gets the batchID value for this Scanning.
     * 
     * @return batchID
     */
    public java.lang.String getBatchID() {
        return batchID;
    }


    /**
     * Sets the batchID value for this Scanning.
     * 
     * @param batchID
     */
    public void setBatchID(java.lang.String batchID) {
        this.batchID = batchID;
    }


    /**
     * Gets the consignmentNote value for this Scanning.
     * 
     * @return consignmentNote
     */
    public java.lang.String getConsignmentNote() {
        return consignmentNote;
    }


    /**
     * Sets the consignmentNote value for this Scanning.
     * 
     * @param consignmentNote
     */
    public void setConsignmentNote(java.lang.String consignmentNote) {
        this.consignmentNote = consignmentNote;
    }


    /**
     * Gets the consignmentPart value for this Scanning.
     * 
     * @return consignmentPart
     */
    public java.lang.String getConsignmentPart() {
        return consignmentPart;
    }


    /**
     * Sets the consignmentPart value for this Scanning.
     * 
     * @param consignmentPart
     */
    public void setConsignmentPart(java.lang.String consignmentPart) {
        this.consignmentPart = consignmentPart;
    }


    /**
     * Gets the driverNum value for this Scanning.
     * 
     * @return driverNum
     */
    public java.lang.String getDriverNum() {
        return driverNum;
    }


    /**
     * Sets the driverNum value for this Scanning.
     * 
     * @param driverNum
     */
    public void setDriverNum(java.lang.String driverNum) {
        this.driverNum = driverNum;
    }


    /**
     * Gets the location value for this Scanning.
     * 
     * @return location
     */
    public java.lang.String getLocation() {
        return location;
    }


    /**
     * Sets the location value for this Scanning.
     * 
     * @param location
     */
    public void setLocation(java.lang.String location) {
        this.location = location;
    }


    /**
     * Gets the scanDate value for this Scanning.
     * 
     * @return scanDate
     */
    public java.util.Calendar getScanDate() {
        return scanDate;
    }


    /**
     * Sets the scanDate value for this Scanning.
     * 
     * @param scanDate
     */
    public void setScanDate(java.util.Calendar scanDate) {
        this.scanDate = scanDate;
    }


    /**
     * Gets the userID value for this Scanning.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this Scanning.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Scanning)) return false;
        Scanning other = (Scanning) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.batchID==null && other.getBatchID()==null) || 
             (this.batchID!=null &&
              this.batchID.equals(other.getBatchID()))) &&
            ((this.consignmentNote==null && other.getConsignmentNote()==null) || 
             (this.consignmentNote!=null &&
              this.consignmentNote.equals(other.getConsignmentNote()))) &&
            ((this.consignmentPart==null && other.getConsignmentPart()==null) || 
             (this.consignmentPart!=null &&
              this.consignmentPart.equals(other.getConsignmentPart()))) &&
            ((this.driverNum==null && other.getDriverNum()==null) || 
             (this.driverNum!=null &&
              this.driverNum.equals(other.getDriverNum()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.scanDate==null && other.getScanDate()==null) || 
             (this.scanDate!=null &&
              this.scanDate.equals(other.getScanDate()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID())));
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
        if (getBatchID() != null) {
            _hashCode += getBatchID().hashCode();
        }
        if (getConsignmentNote() != null) {
            _hashCode += getConsignmentNote().hashCode();
        }
        if (getConsignmentPart() != null) {
            _hashCode += getConsignmentPart().hashCode();
        }
        if (getDriverNum() != null) {
            _hashCode += getDriverNum().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getScanDate() != null) {
            _hashCode += getScanDate().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Scanning.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Scanning"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "batchID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consignmentNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consignmentNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consignmentPart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consignmentPart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("driverNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "driverNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("", "location"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scanDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userID"));
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
