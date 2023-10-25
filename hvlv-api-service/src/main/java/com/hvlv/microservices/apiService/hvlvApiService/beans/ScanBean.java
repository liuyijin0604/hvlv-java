package com.hvlv.microservices.apiService.hvlvApiService.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScanBean {

    private java.lang.String batchID;

    private java.lang.String consignmentNote;

    private java.lang.String consignmentPart;

    private java.lang.String driverNum;

    private java.lang.String location;

    private java.util.Calendar scanDate;

    private java.lang.String userID;

    private String scanDateStr;


    public ScanBean(String batchID, String consignmentNote, String consignmentPart, String driverNum, String location, Calendar scanDate, String userID) {
        this.batchID = batchID;
        this.consignmentNote = consignmentNote;
        this.consignmentPart = consignmentPart;
        this.driverNum = driverNum;
        this.location = location;
        this.scanDate = scanDate;
        this.userID = userID;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
        scanDateStr = dateFormat.format(this.scanDate.getTime());
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getConsignmentNote() {
        return consignmentNote;
    }

    public void setConsignmentNote(String consignmentNote) {
        this.consignmentNote = consignmentNote;
    }

    public String getConsignmentPart() {
        return consignmentPart;
    }

    public void setConsignmentPart(String consignmentPart) {
        this.consignmentPart = consignmentPart;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Calendar getScanDate() {
        return scanDate;
    }

    public void setScanDate(Calendar scanDate) {
        this.scanDate = scanDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getScanDateStr() {
        return scanDateStr;
    }

    public void setScanDateStr(String scanDateStr) {
        this.scanDateStr = scanDateStr;
    }
}
