/**
 * TTWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.allied;

public interface TTWS extends java.rmi.Remote {
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job bookLocalCourierJob(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Job job_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.JobPrice calculatePrice(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Job job_2) throws java.rmi.RemoteException;
    public int cancelDispatchJob(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3) throws java.rmi.RemoteException;
    public void cancelJob(java.lang.String string_1, int int_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public void cancelPendingJob(java.lang.String string_1, int int_2) throws java.rmi.RemoteException;
    public void chargeJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public void deletePendingJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job[] dispatchPendingJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public byte[] generateLabel(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Job job_2, int int_3) throws java.rmi.RemoteException;
    public byte[] generateSpecificLabel(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.JobLabel jobLabel_2, int int_3, int int_4) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Account getAccountDefaults(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job[] getChargedJobs(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Account account_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job[] getDispatchedJobs(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Account account_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job[] getIntranetJobs(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5) throws java.rmi.RemoteException;
    public java.lang.String getJobAsXML(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job getJobDetails(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5) throws java.rmi.RemoteException;
    public byte[] getLabel(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5, int int_6) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Account getLocalCourierAccountDefaults(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job getLocalCourierJobDetails(java.lang.String string_1, int int_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job[] getPendingJobs(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Account account_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.ShipmentStatus getShipmentsStatus(java.lang.String string_1, java.lang.String string_2) throws java.rmi.RemoteException;
    public void hideJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job quoteLocalCourierJob(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Job job_2) throws java.rmi.RemoteException;
    public void savePendingJob(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Job job_2) throws java.rmi.RemoteException;
    public void setNote(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Note note_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Job validateBooking(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.Job job_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.JobExt validateBookingExt(java.lang.String string_1, com.hvlv.microservices.apiService.hvlvApiService.allied.JobExt jobExt_2) throws java.rmi.RemoteException;
    public com.hvlv.microservices.apiService.hvlvApiService.allied.Client validateClient(java.lang.String string_1) throws java.rmi.RemoteException;
}
