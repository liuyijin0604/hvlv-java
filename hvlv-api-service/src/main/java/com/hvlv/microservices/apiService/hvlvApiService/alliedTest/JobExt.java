/**
 * JobExt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class JobExt  implements java.io.Serializable {
    private double freightOversizedHomeDel;

    private ItemExt[] itemsExt;

    private Job job;

    private double onForwardChargeDelivery;

    private double onForwardChargePickup;

    private int quoteNumber;

    public JobExt() {
    }

    public JobExt(
           double freightOversizedHomeDel,
           ItemExt[] itemsExt,
           Job job,
           double onForwardChargeDelivery,
           double onForwardChargePickup,
           int quoteNumber) {
           this.freightOversizedHomeDel = freightOversizedHomeDel;
           this.itemsExt = itemsExt;
           this.job = job;
           this.onForwardChargeDelivery = onForwardChargeDelivery;
           this.onForwardChargePickup = onForwardChargePickup;
           this.quoteNumber = quoteNumber;
    }


    /**
     * Gets the freightOversizedHomeDel value for this JobExt.
     * 
     * @return freightOversizedHomeDel
     */
    public double getFreightOversizedHomeDel() {
        return freightOversizedHomeDel;
    }


    /**
     * Sets the freightOversizedHomeDel value for this JobExt.
     * 
     * @param freightOversizedHomeDel
     */
    public void setFreightOversizedHomeDel(double freightOversizedHomeDel) {
        this.freightOversizedHomeDel = freightOversizedHomeDel;
    }


    /**
     * Gets the itemsExt value for this JobExt.
     * 
     * @return itemsExt
     */
    public ItemExt[] getItemsExt() {
        return itemsExt;
    }


    /**
     * Sets the itemsExt value for this JobExt.
     * 
     * @param itemsExt
     */
    public void setItemsExt(ItemExt[] itemsExt) {
        this.itemsExt = itemsExt;
    }

    public ItemExt getItemsExt(int i) {
        return this.itemsExt[i];
    }

    public void setItemsExt(int i, ItemExt _value) {
        this.itemsExt[i] = _value;
    }


    /**
     * Gets the job value for this JobExt.
     * 
     * @return job
     */
    public Job getJob() {
        return job;
    }


    /**
     * Sets the job value for this JobExt.
     * 
     * @param job
     */
    public void setJob(Job job) {
        this.job = job;
    }


    /**
     * Gets the onForwardChargeDelivery value for this JobExt.
     * 
     * @return onForwardChargeDelivery
     */
    public double getOnForwardChargeDelivery() {
        return onForwardChargeDelivery;
    }


    /**
     * Sets the onForwardChargeDelivery value for this JobExt.
     * 
     * @param onForwardChargeDelivery
     */
    public void setOnForwardChargeDelivery(double onForwardChargeDelivery) {
        this.onForwardChargeDelivery = onForwardChargeDelivery;
    }


    /**
     * Gets the onForwardChargePickup value for this JobExt.
     * 
     * @return onForwardChargePickup
     */
    public double getOnForwardChargePickup() {
        return onForwardChargePickup;
    }


    /**
     * Sets the onForwardChargePickup value for this JobExt.
     * 
     * @param onForwardChargePickup
     */
    public void setOnForwardChargePickup(double onForwardChargePickup) {
        this.onForwardChargePickup = onForwardChargePickup;
    }


    /**
     * Gets the quoteNumber value for this JobExt.
     * 
     * @return quoteNumber
     */
    public int getQuoteNumber() {
        return quoteNumber;
    }


    /**
     * Sets the quoteNumber value for this JobExt.
     * 
     * @param quoteNumber
     */
    public void setQuoteNumber(int quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JobExt)) return false;
        JobExt other = (JobExt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.freightOversizedHomeDel == other.getFreightOversizedHomeDel() &&
            ((this.itemsExt==null && other.getItemsExt()==null) || 
             (this.itemsExt!=null &&
              java.util.Arrays.equals(this.itemsExt, other.getItemsExt()))) &&
            ((this.job==null && other.getJob()==null) || 
             (this.job!=null &&
              this.job.equals(other.getJob()))) &&
            this.onForwardChargeDelivery == other.getOnForwardChargeDelivery() &&
            this.onForwardChargePickup == other.getOnForwardChargePickup() &&
            this.quoteNumber == other.getQuoteNumber();
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
        _hashCode += new Double(getFreightOversizedHomeDel()).hashCode();
        if (getItemsExt() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItemsExt());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItemsExt(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJob() != null) {
            _hashCode += getJob().hashCode();
        }
        _hashCode += new Double(getOnForwardChargeDelivery()).hashCode();
        _hashCode += new Double(getOnForwardChargePickup()).hashCode();
        _hashCode += getQuoteNumber();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JobExt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobExt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freightOversizedHomeDel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freightOversizedHomeDel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemsExt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemsExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "ItemExt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job");
        elemField.setXmlName(new javax.xml.namespace.QName("", "job"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Job"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onForwardChargeDelivery");
        elemField.setXmlName(new javax.xml.namespace.QName("", "onForwardChargeDelivery"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onForwardChargePickup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "onForwardChargePickup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quoteNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quoteNumber"));
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
