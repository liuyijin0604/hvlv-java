package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoogleReview implements Serializable {
    private Integer id;

    private String hbn;

    private String ref;

    private Date timeStart;

    private Date timeDone;

    private String cneeName;

    private String cneeEmail;

    private String cneeTel;

    private String cnorCity;

    private String cnorState;

    private Integer pkg;

    private BigDecimal weight;

    private Date timeArrived;

    private Integer shipmentId;

    private Integer cargoProcessId;

    private Integer status;

    private Date timeCreated;

    private Date timeProcessed;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHbn() {
        return hbn;
    }

    public void setHbn(String hbn) {
        this.hbn = hbn;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeDone() {
        return timeDone;
    }

    public void setTimeDone(Date timeDone) {
        this.timeDone = timeDone;
    }

    public String getCneeName() {
        return cneeName;
    }

    public void setCneeName(String cneeName) {
        this.cneeName = cneeName;
    }

    public String getCneeEmail() {
        return cneeEmail;
    }

    public void setCneeEmail(String cneeEmail) {
        this.cneeEmail = cneeEmail;
    }

    public String getCneeTel() {
        return cneeTel;
    }

    public void setCneeTel(String cneeTel) {
        this.cneeTel = cneeTel;
    }

    public String getCnorCity() {
        return cnorCity;
    }

    public void setCnorCity(String cnorCity) {
        this.cnorCity = cnorCity;
    }

    public String getCnorState() {
        return cnorState;
    }

    public void setCnorState(String cnorState) {
        this.cnorState = cnorState;
    }

    public Integer getPkg() {
        return pkg;
    }

    public void setPkg(Integer pkg) {
        this.pkg = pkg;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getTimeArrived() {
        return timeArrived;
    }

    public void setTimeArrived(Date timeArrived) {
        this.timeArrived = timeArrived;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getCargoProcessId() {
        return cargoProcessId;
    }

    public void setCargoProcessId(Integer cargoProcessId) {
        this.cargoProcessId = cargoProcessId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeProcessed() {
        return timeProcessed;
    }

    public void setTimeProcessed(Date timeProcessed) {
        this.timeProcessed = timeProcessed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hbn=").append(hbn);
        sb.append(", ref=").append(ref);
        sb.append(", timeStart=").append(timeStart);
        sb.append(", timeDone=").append(timeDone);
        sb.append(", cneeName=").append(cneeName);
        sb.append(", cneeEmail=").append(cneeEmail);
        sb.append(", cneeTel=").append(cneeTel);
        sb.append(", cnorCity=").append(cnorCity);
        sb.append(", cnorState=").append(cnorState);
        sb.append(", pkg=").append(pkg);
        sb.append(", weight=").append(weight);
        sb.append(", timeArrived=").append(timeArrived);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", cargoProcessId=").append(cargoProcessId);
        sb.append(", status=").append(status);
        sb.append(", timeCreated=").append(timeCreated);
        sb.append(", timeProcessed=").append(timeProcessed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}