/**
 * TnTWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public interface TnTWebService extends javax.xml.rpc.Service {
    public java.lang.String getTTWSPortAddress();

    public com.hvlv.microservices.apiService.hvlvApiService.allied.TTWS getTTWSPort() throws javax.xml.rpc.ServiceException;

    public com.hvlv.microservices.apiService.hvlvApiService.allied.TTWS getTTWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
