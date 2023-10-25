/**
 * TTWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hvlv.microservices.apiService.hvlvApiService.alliedTest;

import com.hvlv.microservices.apiService.hvlvApiService.alliedTest.*;

public interface TTWS extends java.rmi.Remote {
    public Job bookLocalCourierJob(java.lang.String string_1, Job job_2) throws java.rmi.RemoteException;
    public JobPrice calculatePrice(java.lang.String string_1, Job job_2) throws java.rmi.RemoteException;
    public int cancelDispatchJob(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3) throws java.rmi.RemoteException;
    public void cancelJob(java.lang.String string_1, int int_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public void cancelPendingJob(java.lang.String string_1, int int_2) throws java.rmi.RemoteException;
    public void chargeJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public void deletePendingJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public Job[] dispatchPendingJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public byte[] generateLabel(java.lang.String string_1, Job job_2, int int_3) throws java.rmi.RemoteException;
    public byte[] generateSpecificLabel(java.lang.String string_1, JobLabel jobLabel_2, int int_3, int int_4) throws java.rmi.RemoteException;
    public Account getAccountDefaults(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public Job[] getChargedJobs(java.lang.String string_1, Account account_2) throws java.rmi.RemoteException;
    public Job[] getDispatchedJobs(java.lang.String string_1, Account account_2) throws java.rmi.RemoteException;
    public Job[] getIntranetJobs(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5) throws java.rmi.RemoteException;
    public java.lang.String getJobAsXML(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public Job getJobDetails(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5) throws java.rmi.RemoteException;
    public byte[] getLabel(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5, int int_6) throws java.rmi.RemoteException;
    public Account getLocalCourierAccountDefaults(java.lang.String string_1, java.lang.String string_2, java.lang.String string_3, java.lang.String string_4) throws java.rmi.RemoteException;
    public Job getLocalCourierJobDetails(java.lang.String string_1, int int_2, java.lang.String string_3, java.lang.String string_4, java.lang.String string_5) throws java.rmi.RemoteException;
    public Job[] getPendingJobs(java.lang.String string_1, Account account_2) throws java.rmi.RemoteException;
    public ShipmentStatus getShipmentsStatus(java.lang.String string_1, java.lang.String string_2) throws java.rmi.RemoteException;
    public void hideJobs(java.lang.String string_1, int[] jobIds_2) throws java.rmi.RemoteException;
    public Job quoteLocalCourierJob(java.lang.String string_1, Job job_2) throws java.rmi.RemoteException;
    public void savePendingJob(java.lang.String string_1, Job job_2) throws java.rmi.RemoteException;
    public void setNote(java.lang.String string_1, Note note_2) throws java.rmi.RemoteException;
    public Job validateBooking(java.lang.String string_1, Job job_2) throws java.rmi.RemoteException;
    public JobExt validateBookingExt(java.lang.String string_1, JobExt jobExt_2) throws java.rmi.RemoteException;
    public Client validateClient(java.lang.String string_1) throws java.rmi.RemoteException;
}
