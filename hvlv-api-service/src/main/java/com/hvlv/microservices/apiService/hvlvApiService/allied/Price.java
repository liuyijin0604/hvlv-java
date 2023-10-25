/**
 * Price.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class Price  implements java.io.Serializable {
    private int chargeQuantity;

    private int cubicFactor;

    private java.lang.String discountClass;

    private double discountRate;

    private double grossPrice;

    private java.lang.String jobCode;

    private double netPrice;

    private java.lang.String rateCode;

    private java.lang.String reason;

    public Price() {
    }

    public Price(
           int chargeQuantity,
           int cubicFactor,
           java.lang.String discountClass,
           double discountRate,
           double grossPrice,
           java.lang.String jobCode,
           double netPrice,
           java.lang.String rateCode,
           java.lang.String reason) {
           this.chargeQuantity = chargeQuantity;
           this.cubicFactor = cubicFactor;
           this.discountClass = discountClass;
           this.discountRate = discountRate;
           this.grossPrice = grossPrice;
           this.jobCode = jobCode;
           this.netPrice = netPrice;
           this.rateCode = rateCode;
           this.reason = reason;
    }


    /**
     * Gets the chargeQuantity value for this Price.
     * 
     * @return chargeQuantity
     */
    public int getChargeQuantity() {
        return chargeQuantity;
    }


    /**
     * Sets the chargeQuantity value for this Price.
     * 
     * @param chargeQuantity
     */
    public void setChargeQuantity(int chargeQuantity) {
        this.chargeQuantity = chargeQuantity;
    }


    /**
     * Gets the cubicFactor value for this Price.
     * 
     * @return cubicFactor
     */
    public int getCubicFactor() {
        return cubicFactor;
    }


    /**
     * Sets the cubicFactor value for this Price.
     * 
     * @param cubicFactor
     */
    public void setCubicFactor(int cubicFactor) {
        this.cubicFactor = cubicFactor;
    }


    /**
     * Gets the discountClass value for this Price.
     * 
     * @return discountClass
     */
    public java.lang.String getDiscountClass() {
        return discountClass;
    }


    /**
     * Sets the discountClass value for this Price.
     * 
     * @param discountClass
     */
    public void setDiscountClass(java.lang.String discountClass) {
        this.discountClass = discountClass;
    }


    /**
     * Gets the discountRate value for this Price.
     * 
     * @return discountRate
     */
    public double getDiscountRate() {
        return discountRate;
    }


    /**
     * Sets the discountRate value for this Price.
     * 
     * @param discountRate
     */
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }


    /**
     * Gets the grossPrice value for this Price.
     * 
     * @return grossPrice
     */
    public double getGrossPrice() {
        return grossPrice;
    }


    /**
     * Sets the grossPrice value for this Price.
     * 
     * @param grossPrice
     */
    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }


    /**
     * Gets the jobCode value for this Price.
     * 
     * @return jobCode
     */
    public java.lang.String getJobCode() {
        return jobCode;
    }


    /**
     * Sets the jobCode value for this Price.
     * 
     * @param jobCode
     */
    public void setJobCode(java.lang.String jobCode) {
        this.jobCode = jobCode;
    }


    /**
     * Gets the netPrice value for this Price.
     * 
     * @return netPrice
     */
    public double getNetPrice() {
        return netPrice;
    }


    /**
     * Sets the netPrice value for this Price.
     * 
     * @param netPrice
     */
    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }


    /**
     * Gets the rateCode value for this Price.
     * 
     * @return rateCode
     */
    public java.lang.String getRateCode() {
        return rateCode;
    }


    /**
     * Sets the rateCode value for this Price.
     * 
     * @param rateCode
     */
    public void setRateCode(java.lang.String rateCode) {
        this.rateCode = rateCode;
    }


    /**
     * Gets the reason value for this Price.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this Price.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Price)) return false;
        Price other = (Price) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.chargeQuantity == other.getChargeQuantity() &&
            this.cubicFactor == other.getCubicFactor() &&
            ((this.discountClass==null && other.getDiscountClass()==null) || 
             (this.discountClass!=null &&
              this.discountClass.equals(other.getDiscountClass()))) &&
            this.discountRate == other.getDiscountRate() &&
            this.grossPrice == other.getGrossPrice() &&
            ((this.jobCode==null && other.getJobCode()==null) || 
             (this.jobCode!=null &&
              this.jobCode.equals(other.getJobCode()))) &&
            this.netPrice == other.getNetPrice() &&
            ((this.rateCode==null && other.getRateCode()==null) || 
             (this.rateCode!=null &&
              this.rateCode.equals(other.getRateCode()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason())));
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
        _hashCode += getChargeQuantity();
        _hashCode += getCubicFactor();
        if (getDiscountClass() != null) {
            _hashCode += getDiscountClass().hashCode();
        }
        _hashCode += new Double(getDiscountRate()).hashCode();
        _hashCode += new Double(getGrossPrice()).hashCode();
        if (getJobCode() != null) {
            _hashCode += getJobCode().hashCode();
        }
        _hashCode += new Double(getNetPrice()).hashCode();
        if (getRateCode() != null) {
            _hashCode += getRateCode().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Price.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Price"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargeQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cubicFactor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cubicFactor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discountClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discountClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discountRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discountRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grossPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grossPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reason"));
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
