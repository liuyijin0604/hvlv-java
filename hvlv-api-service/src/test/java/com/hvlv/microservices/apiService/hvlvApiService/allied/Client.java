/**
 * Client.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public class Client  implements java.io.Serializable {
    private java.lang.String[] clientCodes;

    private int clientID;

    private java.lang.String clientName;

    private java.lang.String defaultShippingDivision;

    private java.lang.String errorTemplate;

    private java.lang.String[] ipAddresses;

    private java.lang.String signature;

    private java.lang.String siteTemplate;

    public Client() {
    }

    public Client(
           java.lang.String[] clientCodes,
           int clientID,
           java.lang.String clientName,
           java.lang.String defaultShippingDivision,
           java.lang.String errorTemplate,
           java.lang.String[] ipAddresses,
           java.lang.String signature,
           java.lang.String siteTemplate) {
           this.clientCodes = clientCodes;
           this.clientID = clientID;
           this.clientName = clientName;
           this.defaultShippingDivision = defaultShippingDivision;
           this.errorTemplate = errorTemplate;
           this.ipAddresses = ipAddresses;
           this.signature = signature;
           this.siteTemplate = siteTemplate;
    }


    /**
     * Gets the clientCodes value for this Client.
     * 
     * @return clientCodes
     */
    public java.lang.String[] getClientCodes() {
        return clientCodes;
    }


    /**
     * Sets the clientCodes value for this Client.
     * 
     * @param clientCodes
     */
    public void setClientCodes(java.lang.String[] clientCodes) {
        this.clientCodes = clientCodes;
    }

    public java.lang.String getClientCodes(int i) {
        return this.clientCodes[i];
    }

    public void setClientCodes(int i, java.lang.String _value) {
        this.clientCodes[i] = _value;
    }


    /**
     * Gets the clientID value for this Client.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this Client.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the clientName value for this Client.
     * 
     * @return clientName
     */
    public java.lang.String getClientName() {
        return clientName;
    }


    /**
     * Sets the clientName value for this Client.
     * 
     * @param clientName
     */
    public void setClientName(java.lang.String clientName) {
        this.clientName = clientName;
    }


    /**
     * Gets the defaultShippingDivision value for this Client.
     * 
     * @return defaultShippingDivision
     */
    public java.lang.String getDefaultShippingDivision() {
        return defaultShippingDivision;
    }


    /**
     * Sets the defaultShippingDivision value for this Client.
     * 
     * @param defaultShippingDivision
     */
    public void setDefaultShippingDivision(java.lang.String defaultShippingDivision) {
        this.defaultShippingDivision = defaultShippingDivision;
    }


    /**
     * Gets the errorTemplate value for this Client.
     * 
     * @return errorTemplate
     */
    public java.lang.String getErrorTemplate() {
        return errorTemplate;
    }


    /**
     * Sets the errorTemplate value for this Client.
     * 
     * @param errorTemplate
     */
    public void setErrorTemplate(java.lang.String errorTemplate) {
        this.errorTemplate = errorTemplate;
    }


    /**
     * Gets the ipAddresses value for this Client.
     * 
     * @return ipAddresses
     */
    public java.lang.String[] getIpAddresses() {
        return ipAddresses;
    }


    /**
     * Sets the ipAddresses value for this Client.
     * 
     * @param ipAddresses
     */
    public void setIpAddresses(java.lang.String[] ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public java.lang.String getIpAddresses(int i) {
        return this.ipAddresses[i];
    }

    public void setIpAddresses(int i, java.lang.String _value) {
        this.ipAddresses[i] = _value;
    }


    /**
     * Gets the signature value for this Client.
     * 
     * @return signature
     */
    public java.lang.String getSignature() {
        return signature;
    }


    /**
     * Sets the signature value for this Client.
     * 
     * @param signature
     */
    public void setSignature(java.lang.String signature) {
        this.signature = signature;
    }


    /**
     * Gets the siteTemplate value for this Client.
     * 
     * @return siteTemplate
     */
    public java.lang.String getSiteTemplate() {
        return siteTemplate;
    }


    /**
     * Sets the siteTemplate value for this Client.
     * 
     * @param siteTemplate
     */
    public void setSiteTemplate(java.lang.String siteTemplate) {
        this.siteTemplate = siteTemplate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Client)) return false;
        Client other = (Client) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clientCodes==null && other.getClientCodes()==null) || 
             (this.clientCodes!=null &&
              java.util.Arrays.equals(this.clientCodes, other.getClientCodes()))) &&
            this.clientID == other.getClientID() &&
            ((this.clientName==null && other.getClientName()==null) || 
             (this.clientName!=null &&
              this.clientName.equals(other.getClientName()))) &&
            ((this.defaultShippingDivision==null && other.getDefaultShippingDivision()==null) || 
             (this.defaultShippingDivision!=null &&
              this.defaultShippingDivision.equals(other.getDefaultShippingDivision()))) &&
            ((this.errorTemplate==null && other.getErrorTemplate()==null) || 
             (this.errorTemplate!=null &&
              this.errorTemplate.equals(other.getErrorTemplate()))) &&
            ((this.ipAddresses==null && other.getIpAddresses()==null) || 
             (this.ipAddresses!=null &&
              java.util.Arrays.equals(this.ipAddresses, other.getIpAddresses()))) &&
            ((this.signature==null && other.getSignature()==null) || 
             (this.signature!=null &&
              this.signature.equals(other.getSignature()))) &&
            ((this.siteTemplate==null && other.getSiteTemplate()==null) || 
             (this.siteTemplate!=null &&
              this.siteTemplate.equals(other.getSiteTemplate())));
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
        if (getClientCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getClientID();
        if (getClientName() != null) {
            _hashCode += getClientName().hashCode();
        }
        if (getDefaultShippingDivision() != null) {
            _hashCode += getDefaultShippingDivision().hashCode();
        }
        if (getErrorTemplate() != null) {
            _hashCode += getErrorTemplate().hashCode();
        }
        if (getIpAddresses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIpAddresses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIpAddresses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSignature() != null) {
            _hashCode += getSignature().hashCode();
        }
        if (getSiteTemplate() != null) {
            _hashCode += getSiteTemplate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Client.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Client"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultShippingDivision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultShippingDivision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorTemplate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipAddresses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ipAddresses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siteTemplate"));
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
