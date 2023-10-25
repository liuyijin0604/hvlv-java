/**
 * JobLabel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class JobLabel  extends com.hvlv.microservices.apiService.hvlvApiService.allied.Job  implements java.io.Serializable {
    private com.hvlv.microservices.apiService.hvlvApiService.allied.ItemLabel[] itemsLabel;

    private int whatLabel;

    public JobLabel() {
    }

    public JobLabel(
           com.hvlv.microservices.apiService.hvlvApiService.allied.Account account,
           java.lang.String bookedBy,
           java.util.Calendar bookedDate,
           java.util.Calendar cancelledDate,
           java.util.Calendar chargedDate,
           java.lang.String closeTime,
           com.hvlv.microservices.apiService.hvlvApiService.allied.CubedItem[] cubedItems,
           double cubicWeight,
           java.util.Calendar deliveryDate,
           java.util.Calendar dispatchedDate,
           java.lang.String docketNumber,
           java.lang.String instructions,
           int itemCount,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Item[] items,
           com.hvlv.microservices.apiService.hvlvApiService.allied.JobError[] jobErrors,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Note[] jobNotes,
           int jobNumber,
           java.lang.String jobStatus,
           com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] jobStops,
           java.lang.String jobType,
           java.lang.String notes,
           java.util.Calendar pickupDate,
           com.hvlv.microservices.apiService.hvlvApiService.allied.POD[] pods,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Price price,
           java.util.Calendar readyDate,
           java.lang.String[] referenceNumbers,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning[] scannings,
           java.util.Calendar scheduledDeliveryDate,
           java.util.Calendar scheduledPickupDate,
           java.lang.String serviceDescription,
           java.lang.String serviceLevel,
           com.hvlv.microservices.apiService.hvlvApiService.allied.ElectronicSignature[] signatures,
           java.lang.String validatedHash,
           com.hvlv.microservices.apiService.hvlvApiService.allied.Vehicle vehicle,
           double volume,
           double weight,
           com.hvlv.microservices.apiService.hvlvApiService.allied.ItemLabel[] itemsLabel,
           int whatLabel) {
        super(
            account,
            bookedBy,
            bookedDate,
            cancelledDate,
            chargedDate,
            closeTime,
            cubedItems,
            cubicWeight,
            deliveryDate,
            dispatchedDate,
            docketNumber,
            instructions,
            itemCount,
            items,
            jobErrors,
            jobNotes,
            jobNumber,
            jobStatus,
            jobStops,
            jobType,
            notes,
            pickupDate,
            pods,
            price,
            readyDate,
            referenceNumbers,
            scannings,
            scheduledDeliveryDate,
            scheduledPickupDate,
            serviceDescription,
            serviceLevel,
            signatures,
            validatedHash,
            vehicle,
            volume,
            weight);
        this.itemsLabel = itemsLabel;
        this.whatLabel = whatLabel;
    }


    /**
     * Gets the itemsLabel value for this JobLabel.
     * 
     * @return itemsLabel
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.ItemLabel[] getItemsLabel() {
        return itemsLabel;
    }


    /**
     * Sets the itemsLabel value for this JobLabel.
     * 
     * @param itemsLabel
     */
    public void setItemsLabel(com.hvlv.microservices.apiService.hvlvApiService.allied.ItemLabel[] itemsLabel) {
        this.itemsLabel = itemsLabel;
    }

    public com.hvlv.microservices.apiService.hvlvApiService.allied.ItemLabel getItemsLabel(int i) {
        return this.itemsLabel[i];
    }

    public void setItemsLabel(int i, com.hvlv.microservices.apiService.hvlvApiService.allied.ItemLabel _value) {
        this.itemsLabel[i] = _value;
    }


    /**
     * Gets the whatLabel value for this JobLabel.
     * 
     * @return whatLabel
     */
    public int getWhatLabel() {
        return whatLabel;
    }


    /**
     * Sets the whatLabel value for this JobLabel.
     * 
     * @param whatLabel
     */
    public void setWhatLabel(int whatLabel) {
        this.whatLabel = whatLabel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JobLabel)) return false;
        JobLabel other = (JobLabel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.itemsLabel==null && other.getItemsLabel()==null) || 
             (this.itemsLabel!=null &&
              java.util.Arrays.equals(this.itemsLabel, other.getItemsLabel()))) &&
            this.whatLabel == other.getWhatLabel();
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
        if (getItemsLabel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItemsLabel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItemsLabel(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getWhatLabel();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JobLabel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobLabel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemsLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemsLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ItemLabel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whatLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "whatLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
