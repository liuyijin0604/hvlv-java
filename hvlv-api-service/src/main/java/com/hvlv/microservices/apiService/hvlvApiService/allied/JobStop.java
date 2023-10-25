/**
 * JobStop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class JobStop  implements java.io.Serializable {
    private java.lang.String companyName;

    private java.lang.String contact;

    private java.lang.String emailAddress;

    private com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress geographicAddress;

    private java.lang.String jobStopFlag;

    private java.lang.String phoneNumber;

    private int stopNumber;

    private java.lang.String stopType;

    public JobStop() {
    }

    public JobStop(
           java.lang.String companyName,
           java.lang.String contact,
           java.lang.String emailAddress,
           com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress geographicAddress,
           java.lang.String jobStopFlag,
           java.lang.String phoneNumber,
           int stopNumber,
           java.lang.String stopType) {
           this.companyName = companyName;
           this.contact = contact;
           this.emailAddress = emailAddress;
           this.geographicAddress = geographicAddress;
           this.jobStopFlag = jobStopFlag;
           this.phoneNumber = phoneNumber;
           this.stopNumber = stopNumber;
           this.stopType = stopType;
    }


    /**
     * Gets the companyName value for this JobStop.
     * 
     * @return companyName
     */
    public java.lang.String getCompanyName() {
        return companyName;
    }


    /**
     * Sets the companyName value for this JobStop.
     * 
     * @param companyName
     */
    public void setCompanyName(java.lang.String companyName) {
        this.companyName = companyName;
    }


    /**
     * Gets the contact value for this JobStop.
     * 
     * @return contact
     */
    public java.lang.String getContact() {
        return contact;
    }


    /**
     * Sets the contact value for this JobStop.
     * 
     * @param contact
     */
    public void setContact(java.lang.String contact) {
        this.contact = contact;
    }


    /**
     * Gets the emailAddress value for this JobStop.
     * 
     * @return emailAddress
     */
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }


    /**
     * Sets the emailAddress value for this JobStop.
     * 
     * @param emailAddress
     */
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }


    /**
     * Gets the geographicAddress value for this JobStop.
     * 
     * @return geographicAddress
     */
    public com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress getGeographicAddress() {
        return geographicAddress;
    }


    /**
     * Sets the geographicAddress value for this JobStop.
     * 
     * @param geographicAddress
     */
    public void setGeographicAddress(com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress geographicAddress) {
        this.geographicAddress = geographicAddress;
    }


    /**
     * Gets the jobStopFlag value for this JobStop.
     * 
     * @return jobStopFlag
     */
    public java.lang.String getJobStopFlag() {
        return jobStopFlag;
    }


    /**
     * Sets the jobStopFlag value for this JobStop.
     * 
     * @param jobStopFlag
     */
    public void setJobStopFlag(java.lang.String jobStopFlag) {
        this.jobStopFlag = jobStopFlag;
    }


    /**
     * Gets the phoneNumber value for this JobStop.
     * 
     * @return phoneNumber
     */
    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Sets the phoneNumber value for this JobStop.
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Gets the stopNumber value for this JobStop.
     * 
     * @return stopNumber
     */
    public int getStopNumber() {
        return stopNumber;
    }


    /**
     * Sets the stopNumber value for this JobStop.
     * 
     * @param stopNumber
     */
    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }


    /**
     * Gets the stopType value for this JobStop.
     * 
     * @return stopType
     */
    public java.lang.String getStopType() {
        return stopType;
    }


    /**
     * Sets the stopType value for this JobStop.
     * 
     * @param stopType
     */
    public void setStopType(java.lang.String stopType) {
        this.stopType = stopType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JobStop)) return false;
        JobStop other = (JobStop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.companyName==null && other.getCompanyName()==null) || 
             (this.companyName!=null &&
              this.companyName.equals(other.getCompanyName()))) &&
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              this.contact.equals(other.getContact()))) &&
            ((this.emailAddress==null && other.getEmailAddress()==null) || 
             (this.emailAddress!=null &&
              this.emailAddress.equals(other.getEmailAddress()))) &&
            ((this.geographicAddress==null && other.getGeographicAddress()==null) || 
             (this.geographicAddress!=null &&
              this.geographicAddress.equals(other.getGeographicAddress()))) &&
            ((this.jobStopFlag==null && other.getJobStopFlag()==null) || 
             (this.jobStopFlag!=null &&
              this.jobStopFlag.equals(other.getJobStopFlag()))) &&
            ((this.phoneNumber==null && other.getPhoneNumber()==null) || 
             (this.phoneNumber!=null &&
              this.phoneNumber.equals(other.getPhoneNumber()))) &&
            this.stopNumber == other.getStopNumber() &&
            ((this.stopType==null && other.getStopType()==null) || 
             (this.stopType!=null &&
              this.stopType.equals(other.getStopType())));
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
        if (getCompanyName() != null) {
            _hashCode += getCompanyName().hashCode();
        }
        if (getContact() != null) {
            _hashCode += getContact().hashCode();
        }
        if (getEmailAddress() != null) {
            _hashCode += getEmailAddress().hashCode();
        }
        if (getGeographicAddress() != null) {
            _hashCode += getGeographicAddress().hashCode();
        }
        if (getJobStopFlag() != null) {
            _hashCode += getJobStopFlag().hashCode();
        }
        if (getPhoneNumber() != null) {
            _hashCode += getPhoneNumber().hashCode();
        }
        _hashCode += getStopNumber();
        if (getStopType() != null) {
            _hashCode += getStopType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JobStop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "JobStop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geographicAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "geographicAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "GeographicAddress"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobStopFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobStopFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stopNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stopNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stopType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stopType"));
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
