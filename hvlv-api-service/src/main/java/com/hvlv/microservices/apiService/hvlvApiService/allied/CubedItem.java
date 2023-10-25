/**
 * CubedItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class CubedItem  extends com.hvlv.microservices.apiService.hvlvApiService.allied.Item  implements java.io.Serializable {
    private java.lang.String barcode;

    private java.lang.String consignment;

    private java.util.Calendar cubedDate;

    private java.lang.String dimensionerName;

    private java.util.Calendar processedDate;

    private java.lang.String status;

    private java.util.Calendar statusDate;

    public CubedItem() {
    }

    public CubedItem(
           boolean dangerous,
           double height,
           int itemCount,
           double length,
           double volume,
           double weight,
           double width,
           java.lang.String barcode,
           java.lang.String consignment,
           java.util.Calendar cubedDate,
           java.lang.String dimensionerName,
           java.util.Calendar processedDate,
           java.lang.String status,
           java.util.Calendar statusDate) {
        super(
            dangerous,
            height,
            itemCount,
            length,
            volume,
            weight,
            width);
        this.barcode = barcode;
        this.consignment = consignment;
        this.cubedDate = cubedDate;
        this.dimensionerName = dimensionerName;
        this.processedDate = processedDate;
        this.status = status;
        this.statusDate = statusDate;
    }


    /**
     * Gets the barcode value for this CubedItem.
     * 
     * @return barcode
     */
    public java.lang.String getBarcode() {
        return barcode;
    }


    /**
     * Sets the barcode value for this CubedItem.
     * 
     * @param barcode
     */
    public void setBarcode(java.lang.String barcode) {
        this.barcode = barcode;
    }


    /**
     * Gets the consignment value for this CubedItem.
     * 
     * @return consignment
     */
    public java.lang.String getConsignment() {
        return consignment;
    }


    /**
     * Sets the consignment value for this CubedItem.
     * 
     * @param consignment
     */
    public void setConsignment(java.lang.String consignment) {
        this.consignment = consignment;
    }


    /**
     * Gets the cubedDate value for this CubedItem.
     * 
     * @return cubedDate
     */
    public java.util.Calendar getCubedDate() {
        return cubedDate;
    }


    /**
     * Sets the cubedDate value for this CubedItem.
     * 
     * @param cubedDate
     */
    public void setCubedDate(java.util.Calendar cubedDate) {
        this.cubedDate = cubedDate;
    }


    /**
     * Gets the dimensionerName value for this CubedItem.
     * 
     * @return dimensionerName
     */
    public java.lang.String getDimensionerName() {
        return dimensionerName;
    }


    /**
     * Sets the dimensionerName value for this CubedItem.
     * 
     * @param dimensionerName
     */
    public void setDimensionerName(java.lang.String dimensionerName) {
        this.dimensionerName = dimensionerName;
    }


    /**
     * Gets the processedDate value for this CubedItem.
     * 
     * @return processedDate
     */
    public java.util.Calendar getProcessedDate() {
        return processedDate;
    }


    /**
     * Sets the processedDate value for this CubedItem.
     * 
     * @param processedDate
     */
    public void setProcessedDate(java.util.Calendar processedDate) {
        this.processedDate = processedDate;
    }


    /**
     * Gets the status value for this CubedItem.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CubedItem.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the statusDate value for this CubedItem.
     * 
     * @return statusDate
     */
    public java.util.Calendar getStatusDate() {
        return statusDate;
    }


    /**
     * Sets the statusDate value for this CubedItem.
     * 
     * @param statusDate
     */
    public void setStatusDate(java.util.Calendar statusDate) {
        this.statusDate = statusDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CubedItem)) return false;
        CubedItem other = (CubedItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.barcode==null && other.getBarcode()==null) || 
             (this.barcode!=null &&
              this.barcode.equals(other.getBarcode()))) &&
            ((this.consignment==null && other.getConsignment()==null) || 
             (this.consignment!=null &&
              this.consignment.equals(other.getConsignment()))) &&
            ((this.cubedDate==null && other.getCubedDate()==null) || 
             (this.cubedDate!=null &&
              this.cubedDate.equals(other.getCubedDate()))) &&
            ((this.dimensionerName==null && other.getDimensionerName()==null) || 
             (this.dimensionerName!=null &&
              this.dimensionerName.equals(other.getDimensionerName()))) &&
            ((this.processedDate==null && other.getProcessedDate()==null) || 
             (this.processedDate!=null &&
              this.processedDate.equals(other.getProcessedDate()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.statusDate==null && other.getStatusDate()==null) || 
             (this.statusDate!=null &&
              this.statusDate.equals(other.getStatusDate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getBarcode() != null) {
            _hashCode += getBarcode().hashCode();
        }
        if (getConsignment() != null) {
            _hashCode += getConsignment().hashCode();
        }
        if (getCubedDate() != null) {
            _hashCode += getCubedDate().hashCode();
        }
        if (getDimensionerName() != null) {
            _hashCode += getDimensionerName().hashCode();
        }
        if (getProcessedDate() != null) {
            _hashCode += getProcessedDate().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatusDate() != null) {
            _hashCode += getStatusDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CubedItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "CubedItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("barcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "barcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consignment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consignment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cubedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cubedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dimensionerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dimensionerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusDate"));
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
