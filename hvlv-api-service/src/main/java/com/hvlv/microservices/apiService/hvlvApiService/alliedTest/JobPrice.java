/**
 * JobPrice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class JobPrice  implements java.io.Serializable {
    private java.lang.String errors;

    private double jobCharge;

    private JobCharge[] surcharges;

    private double totalCharge;

    public JobPrice() {
    }

    public JobPrice(
           java.lang.String errors,
           double jobCharge,
           JobCharge[] surcharges,
           double totalCharge) {
           this.errors = errors;
           this.jobCharge = jobCharge;
           this.surcharges = surcharges;
           this.totalCharge = totalCharge;
    }


    /**
     * Gets the errors value for this JobPrice.
     * 
     * @return errors
     */
    public java.lang.String getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this JobPrice.
     * 
     * @param errors
     */
    public void setErrors(java.lang.String errors) {
        this.errors = errors;
    }


    /**
     * Gets the jobCharge value for this JobPrice.
     * 
     * @return jobCharge
     */
    public double getJobCharge() {
        return jobCharge;
    }


    /**
     * Sets the jobCharge value for this JobPrice.
     * 
     * @param jobCharge
     */
    public void setJobCharge(double jobCharge) {
        this.jobCharge = jobCharge;
    }


    /**
     * Gets the surcharges value for this JobPrice.
     * 
     * @return surcharges
     */
    public JobCharge[] getSurcharges() {
        return surcharges;
    }


    /**
     * Sets the surcharges value for this JobPrice.
     * 
     * @param surcharges
     */
    public void setSurcharges(JobCharge[] surcharges) {
        this.surcharges = surcharges;
    }

    public JobCharge getSurcharges(int i) {
        return this.surcharges[i];
    }

    public void setSurcharges(int i, JobCharge _value) {
        this.surcharges[i] = _value;
    }


    /**
     * Gets the totalCharge value for this JobPrice.
     * 
     * @return totalCharge
     */
    public double getTotalCharge() {
        return totalCharge;
    }


    /**
     * Sets the totalCharge value for this JobPrice.
     * 
     * @param totalCharge
     */
    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JobPrice)) return false;
        JobPrice other = (JobPrice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              this.errors.equals(other.getErrors()))) &&
            this.jobCharge == other.getJobCharge() &&
            ((this.surcharges==null && other.getSurcharges()==null) || 
             (this.surcharges!=null &&
              java.util.Arrays.equals(this.surcharges, other.getSurcharges()))) &&
            this.totalCharge == other.getTotalCharge();
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
        if (getErrors() != null) {
            _hashCode += getErrors().hashCode();
        }
        _hashCode += new Double(getJobCharge()).hashCode();
        if (getSurcharges() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSurcharges());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSurcharges(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getTotalCharge()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JobPrice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobPrice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("surcharges");
        elemField.setXmlName(new javax.xml.namespace.QName("", "surcharges"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobCharge"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalCharge"));
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
