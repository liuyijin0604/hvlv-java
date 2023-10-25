/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class Account  implements java.io.Serializable {
    private java.lang.String accountCode;

    private java.lang.String accountHash;

    private int accountKey;

    private java.lang.String accountLedger;

    private java.lang.String accountName;

    private java.lang.String accountState;

    private java.lang.String defaultAddress;

    private java.lang.String defaultContact;

    private java.lang.String defaultPhoneNo;

    private java.lang.String defaultPostCode;

    private java.lang.String defaultState;

    private java.lang.String defaultSuburbName;

    private int discountLevel;

    private boolean priceSuppressed;

    private java.lang.String shippingDivision;

    public Account() {
    }

    public Account(
           java.lang.String accountCode,
           java.lang.String accountHash,
           int accountKey,
           java.lang.String accountLedger,
           java.lang.String accountName,
           java.lang.String accountState,
           java.lang.String defaultAddress,
           java.lang.String defaultContact,
           java.lang.String defaultPhoneNo,
           java.lang.String defaultPostCode,
           java.lang.String defaultState,
           java.lang.String defaultSuburbName,
           int discountLevel,
           boolean priceSuppressed,
           java.lang.String shippingDivision) {
           this.accountCode = accountCode;
           this.accountHash = accountHash;
           this.accountKey = accountKey;
           this.accountLedger = accountLedger;
           this.accountName = accountName;
           this.accountState = accountState;
           this.defaultAddress = defaultAddress;
           this.defaultContact = defaultContact;
           this.defaultPhoneNo = defaultPhoneNo;
           this.defaultPostCode = defaultPostCode;
           this.defaultState = defaultState;
           this.defaultSuburbName = defaultSuburbName;
           this.discountLevel = discountLevel;
           this.priceSuppressed = priceSuppressed;
           this.shippingDivision = shippingDivision;
    }


    /**
     * Gets the accountCode value for this Account.
     * 
     * @return accountCode
     */
    public java.lang.String getAccountCode() {
        return accountCode;
    }


    /**
     * Sets the accountCode value for this Account.
     * 
     * @param accountCode
     */
    public void setAccountCode(java.lang.String accountCode) {
        this.accountCode = accountCode;
    }


    /**
     * Gets the accountHash value for this Account.
     * 
     * @return accountHash
     */
    public java.lang.String getAccountHash() {
        return accountHash;
    }


    /**
     * Sets the accountHash value for this Account.
     * 
     * @param accountHash
     */
    public void setAccountHash(java.lang.String accountHash) {
        this.accountHash = accountHash;
    }


    /**
     * Gets the accountKey value for this Account.
     * 
     * @return accountKey
     */
    public int getAccountKey() {
        return accountKey;
    }


    /**
     * Sets the accountKey value for this Account.
     * 
     * @param accountKey
     */
    public void setAccountKey(int accountKey) {
        this.accountKey = accountKey;
    }


    /**
     * Gets the accountLedger value for this Account.
     * 
     * @return accountLedger
     */
    public java.lang.String getAccountLedger() {
        return accountLedger;
    }


    /**
     * Sets the accountLedger value for this Account.
     * 
     * @param accountLedger
     */
    public void setAccountLedger(java.lang.String accountLedger) {
        this.accountLedger = accountLedger;
    }


    /**
     * Gets the accountName value for this Account.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this Account.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the accountState value for this Account.
     * 
     * @return accountState
     */
    public java.lang.String getAccountState() {
        return accountState;
    }


    /**
     * Sets the accountState value for this Account.
     * 
     * @param accountState
     */
    public void setAccountState(java.lang.String accountState) {
        this.accountState = accountState;
    }


    /**
     * Gets the defaultAddress value for this Account.
     * 
     * @return defaultAddress
     */
    public java.lang.String getDefaultAddress() {
        return defaultAddress;
    }


    /**
     * Sets the defaultAddress value for this Account.
     * 
     * @param defaultAddress
     */
    public void setDefaultAddress(java.lang.String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }


    /**
     * Gets the defaultContact value for this Account.
     * 
     * @return defaultContact
     */
    public java.lang.String getDefaultContact() {
        return defaultContact;
    }


    /**
     * Sets the defaultContact value for this Account.
     * 
     * @param defaultContact
     */
    public void setDefaultContact(java.lang.String defaultContact) {
        this.defaultContact = defaultContact;
    }


    /**
     * Gets the defaultPhoneNo value for this Account.
     * 
     * @return defaultPhoneNo
     */
    public java.lang.String getDefaultPhoneNo() {
        return defaultPhoneNo;
    }


    /**
     * Sets the defaultPhoneNo value for this Account.
     * 
     * @param defaultPhoneNo
     */
    public void setDefaultPhoneNo(java.lang.String defaultPhoneNo) {
        this.defaultPhoneNo = defaultPhoneNo;
    }


    /**
     * Gets the defaultPostCode value for this Account.
     * 
     * @return defaultPostCode
     */
    public java.lang.String getDefaultPostCode() {
        return defaultPostCode;
    }


    /**
     * Sets the defaultPostCode value for this Account.
     * 
     * @param defaultPostCode
     */
    public void setDefaultPostCode(java.lang.String defaultPostCode) {
        this.defaultPostCode = defaultPostCode;
    }


    /**
     * Gets the defaultState value for this Account.
     * 
     * @return defaultState
     */
    public java.lang.String getDefaultState() {
        return defaultState;
    }


    /**
     * Sets the defaultState value for this Account.
     * 
     * @param defaultState
     */
    public void setDefaultState(java.lang.String defaultState) {
        this.defaultState = defaultState;
    }


    /**
     * Gets the defaultSuburbName value for this Account.
     * 
     * @return defaultSuburbName
     */
    public java.lang.String getDefaultSuburbName() {
        return defaultSuburbName;
    }


    /**
     * Sets the defaultSuburbName value for this Account.
     * 
     * @param defaultSuburbName
     */
    public void setDefaultSuburbName(java.lang.String defaultSuburbName) {
        this.defaultSuburbName = defaultSuburbName;
    }


    /**
     * Gets the discountLevel value for this Account.
     * 
     * @return discountLevel
     */
    public int getDiscountLevel() {
        return discountLevel;
    }


    /**
     * Sets the discountLevel value for this Account.
     * 
     * @param discountLevel
     */
    public void setDiscountLevel(int discountLevel) {
        this.discountLevel = discountLevel;
    }


    /**
     * Gets the priceSuppressed value for this Account.
     * 
     * @return priceSuppressed
     */
    public boolean isPriceSuppressed() {
        return priceSuppressed;
    }


    /**
     * Sets the priceSuppressed value for this Account.
     * 
     * @param priceSuppressed
     */
    public void setPriceSuppressed(boolean priceSuppressed) {
        this.priceSuppressed = priceSuppressed;
    }


    /**
     * Gets the shippingDivision value for this Account.
     * 
     * @return shippingDivision
     */
    public java.lang.String getShippingDivision() {
        return shippingDivision;
    }


    /**
     * Sets the shippingDivision value for this Account.
     * 
     * @param shippingDivision
     */
    public void setShippingDivision(java.lang.String shippingDivision) {
        this.shippingDivision = shippingDivision;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Account)) return false;
        Account other = (Account) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountCode==null && other.getAccountCode()==null) || 
             (this.accountCode!=null &&
              this.accountCode.equals(other.getAccountCode()))) &&
            ((this.accountHash==null && other.getAccountHash()==null) || 
             (this.accountHash!=null &&
              this.accountHash.equals(other.getAccountHash()))) &&
            this.accountKey == other.getAccountKey() &&
            ((this.accountLedger==null && other.getAccountLedger()==null) || 
             (this.accountLedger!=null &&
              this.accountLedger.equals(other.getAccountLedger()))) &&
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName()))) &&
            ((this.accountState==null && other.getAccountState()==null) || 
             (this.accountState!=null &&
              this.accountState.equals(other.getAccountState()))) &&
            ((this.defaultAddress==null && other.getDefaultAddress()==null) || 
             (this.defaultAddress!=null &&
              this.defaultAddress.equals(other.getDefaultAddress()))) &&
            ((this.defaultContact==null && other.getDefaultContact()==null) || 
             (this.defaultContact!=null &&
              this.defaultContact.equals(other.getDefaultContact()))) &&
            ((this.defaultPhoneNo==null && other.getDefaultPhoneNo()==null) || 
             (this.defaultPhoneNo!=null &&
              this.defaultPhoneNo.equals(other.getDefaultPhoneNo()))) &&
            ((this.defaultPostCode==null && other.getDefaultPostCode()==null) || 
             (this.defaultPostCode!=null &&
              this.defaultPostCode.equals(other.getDefaultPostCode()))) &&
            ((this.defaultState==null && other.getDefaultState()==null) || 
             (this.defaultState!=null &&
              this.defaultState.equals(other.getDefaultState()))) &&
            ((this.defaultSuburbName==null && other.getDefaultSuburbName()==null) || 
             (this.defaultSuburbName!=null &&
              this.defaultSuburbName.equals(other.getDefaultSuburbName()))) &&
            this.discountLevel == other.getDiscountLevel() &&
            this.priceSuppressed == other.isPriceSuppressed() &&
            ((this.shippingDivision==null && other.getShippingDivision()==null) || 
             (this.shippingDivision!=null &&
              this.shippingDivision.equals(other.getShippingDivision())));
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
        if (getAccountCode() != null) {
            _hashCode += getAccountCode().hashCode();
        }
        if (getAccountHash() != null) {
            _hashCode += getAccountHash().hashCode();
        }
        _hashCode += getAccountKey();
        if (getAccountLedger() != null) {
            _hashCode += getAccountLedger().hashCode();
        }
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        if (getAccountState() != null) {
            _hashCode += getAccountState().hashCode();
        }
        if (getDefaultAddress() != null) {
            _hashCode += getDefaultAddress().hashCode();
        }
        if (getDefaultContact() != null) {
            _hashCode += getDefaultContact().hashCode();
        }
        if (getDefaultPhoneNo() != null) {
            _hashCode += getDefaultPhoneNo().hashCode();
        }
        if (getDefaultPostCode() != null) {
            _hashCode += getDefaultPostCode().hashCode();
        }
        if (getDefaultState() != null) {
            _hashCode += getDefaultState().hashCode();
        }
        if (getDefaultSuburbName() != null) {
            _hashCode += getDefaultSuburbName().hashCode();
        }
        _hashCode += getDiscountLevel();
        _hashCode += (isPriceSuppressed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getShippingDivision() != null) {
            _hashCode += getShippingDivision().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Account.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb/types", "Account"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountHash");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountLedger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountLedger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultContact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultContact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultPhoneNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultPhoneNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultPostCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultPostCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultSuburbName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultSuburbName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discountLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discountLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priceSuppressed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "priceSuppressed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shippingDivision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shippingDivision"));
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
