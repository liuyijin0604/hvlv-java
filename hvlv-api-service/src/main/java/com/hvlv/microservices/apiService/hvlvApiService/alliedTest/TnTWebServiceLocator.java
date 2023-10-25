/**
 * TnTWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

public class TnTWebServiceLocator extends org.apache.axis.client.Service implements TnTWebService {

    public TnTWebServiceLocator() {
    }


    public TnTWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TnTWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TTWSPort
    private java.lang.String TTWSPort_address = "http://triton2:8080/ttws-ejb/TTWS";

    public java.lang.String getTTWSPortAddress() {
        return TTWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TTWSPortWSDDServiceName = "TTWSPort";

    public java.lang.String getTTWSPortWSDDServiceName() {
        return TTWSPortWSDDServiceName;
    }

    public void setTTWSPortWSDDServiceName(java.lang.String name) {
        TTWSPortWSDDServiceName = name;
    }

    public TTWS getTTWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TTWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTTWSPort(endpoint);
    }

    public TTWS getTTWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TTWSBindingStub _stub = new TTWSBindingStub(portAddress, this);
            _stub.setPortName(getTTWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTTWSPortEndpointAddress(java.lang.String address) {
        TTWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (TTWS.class.isAssignableFrom(serviceEndpointInterface)) {
                TTWSBindingStub _stub = new TTWSBindingStub(new java.net.URL(TTWSPort_address), this);
                _stub.setPortName(getTTWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TTWSPort".equals(inputPortName)) {
            return getTTWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb", "TnTWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://neptune.alliedexpress.com.au/ttws-ejb", "TTWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TTWSPort".equals(portName)) {
            setTTWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
