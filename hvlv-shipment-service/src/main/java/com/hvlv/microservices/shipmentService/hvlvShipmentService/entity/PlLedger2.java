package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PlLedger2 implements Serializable {
    private Integer id;

    private Integer fid;

    private String model;

    private Integer orgId;

    private Integer dptId;

    private Byte dpmt;

    private Integer lid;

    private String grp1;

    private String grp2;

    private String grp3;

    private Integer gl;

    private Date date;

    private BigDecimal amt;

    private BigDecimal actualAmt;

    private BigDecimal gst;

    private byte[] acc;

    private BigDecimal weight;

    private String zone;

    private Date invCdate;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Byte getDpmt() {
        return dpmt;
    }

    public void setDpmt(Byte dpmt) {
        this.dpmt = dpmt;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getGrp1() {
        return grp1;
    }

    public void setGrp1(String grp1) {
        this.grp1 = grp1;
    }

    public String getGrp2() {
        return grp2;
    }

    public void setGrp2(String grp2) {
        this.grp2 = grp2;
    }

    public String getGrp3() {
        return grp3;
    }

    public void setGrp3(String grp3) {
        this.grp3 = grp3;
    }

    public Integer getGl() {
        return gl;
    }

    public void setGl(Integer gl) {
        this.gl = gl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getActualAmt() {
        return actualAmt;
    }

    public void setActualAmt(BigDecimal actualAmt) {
        this.actualAmt = actualAmt;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public byte[] getAcc() {
        return acc;
    }

    public void setAcc(byte[] acc) {
        this.acc = acc;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Date getInvCdate() {
        return invCdate;
    }

    public void setInvCdate(Date invCdate) {
        this.invCdate = invCdate;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fid=").append(fid);
        sb.append(", model=").append(model);
        sb.append(", orgId=").append(orgId);
        sb.append(", dptId=").append(dptId);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", lid=").append(lid);
        sb.append(", grp1=").append(grp1);
        sb.append(", grp2=").append(grp2);
        sb.append(", grp3=").append(grp3);
        sb.append(", gl=").append(gl);
        sb.append(", date=").append(date);
        sb.append(", amt=").append(amt);
        sb.append(", actualAmt=").append(actualAmt);
        sb.append(", gst=").append(gst);
        sb.append(", acc=").append(acc);
        sb.append(", weight=").append(weight);
        sb.append(", zone=").append(zone);
        sb.append(", invCdate=").append(invCdate);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}