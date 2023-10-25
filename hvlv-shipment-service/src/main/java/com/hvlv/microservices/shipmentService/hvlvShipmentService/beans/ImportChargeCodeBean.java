package com.hvlv.microservices.shipmentService.hvlvShipmentService.beans;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.List;

public class ImportChargeCodeBean {
    private Integer id;
    private Integer orgId;
    private String chargecode;
    private List<Integer> couriers;
    private Date created;
    private Byte status;
    private Byte statusMode;
    private Date vFrom;
    private Date vTo;
    private String note;
    private Integer dpmt;
    private String description;
    private JSONObject mdata;
    private Integer chargeWt;


    public static final String SYDNEY_AUPOST_ID_CODE = "au_post_eparcel_2019";
    public static final String MELBOUNE_AUPOST_ID_CODE = "au_post_eparcel_mel";
    public static final String BRISBANE_AUPOST_ID_CODE = "au_post_eparcel_bri";
    public static final String PERTH_AUPOST_ID_CODE = "au_post_eparcel_per";
    public static final String AUPOST_INTERNATIONAL_CODE = "aupost_international";
    public static final String AUPOST_EXPRESS_CODE = "aupost_express";

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getChargecode() {
        return chargecode;
    }

    public void setChargecode(String chargecode) {
        this.chargecode = chargecode;
    }

    public List<Integer> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Integer> couriers) {
        this.couriers = couriers;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getStatusMode() {
        return statusMode;
    }

    public void setStatusMode(Byte statusMode) {
        this.statusMode = statusMode;
    }

    public Date getvFrom() {
        return vFrom;
    }

    public void setvFrom(Date vFrom) {
        this.vFrom = vFrom;
    }

    public Date getvTo() {
        return vTo;
    }

    public void setvTo(Date vTo) {
        this.vTo = vTo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChargeWt(Integer chargeWt) {
        this.chargeWt = chargeWt;
    }

    public JSONObject getMdata() {
        return mdata;
    }

    public void setMdata(JSONObject mdata) {
        this.mdata = mdata;
    }

    public int getChargeWt() {
        return chargeWt;
    }

    public void setChargeWt(int chargeWt) {
        this.chargeWt = chargeWt;
    }
}
