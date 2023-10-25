package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImportsFlexibleSurcharge implements Serializable {
    private Integer id;

    private Integer rateId;

    private Integer chargecodeId;

    private String code;

    private String type;

    private String courierType;

    private BigDecimal kgdwf;

    private BigDecimal kgdwt;

    private BigDecimal kgcwf;

    private BigDecimal kgcwt;

    private BigDecimal meterf;

    private BigDecimal metert;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal height;

    private BigDecimal cbm;

    private BigDecimal pPiece;

    private BigDecimal pShipment;

    private Integer status;

    private Date created;

    private BigDecimal pPercent;

    private Date start;

    private Date end;

    private Integer version;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Integer getChargecodeId() {
        return chargecodeId;
    }

    public void setChargecodeId(Integer chargecodeId) {
        this.chargecodeId = chargecodeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourierType() {
        return courierType;
    }

    public void setCourierType(String courierType) {
        this.courierType = courierType;
    }

    public BigDecimal getKgdwf() {
        return kgdwf;
    }

    public void setKgdwf(BigDecimal kgdwf) {
        this.kgdwf = kgdwf;
    }

    public BigDecimal getKgdwt() {
        return kgdwt;
    }

    public void setKgdwt(BigDecimal kgdwt) {
        this.kgdwt = kgdwt;
    }

    public BigDecimal getKgcwf() {
        return kgcwf;
    }

    public void setKgcwf(BigDecimal kgcwf) {
        this.kgcwf = kgcwf;
    }

    public BigDecimal getKgcwt() {
        return kgcwt;
    }

    public void setKgcwt(BigDecimal kgcwt) {
        this.kgcwt = kgcwt;
    }

    public BigDecimal getMeterf() {
        return meterf;
    }

    public void setMeterf(BigDecimal meterf) {
        this.meterf = meterf;
    }

    public BigDecimal getMetert() {
        return metert;
    }

    public void setMetert(BigDecimal metert) {
        this.metert = metert;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getCbm() {
        return cbm;
    }

    public void setCbm(BigDecimal cbm) {
        this.cbm = cbm;
    }

    public BigDecimal getpPiece() {
        return pPiece;
    }

    public void setpPiece(BigDecimal pPiece) {
        this.pPiece = pPiece;
    }

    public BigDecimal getpShipment() {
        return pShipment;
    }

    public void setpShipment(BigDecimal pShipment) {
        this.pShipment = pShipment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BigDecimal getpPercent() {
        return pPercent;
    }

    public void setpPercent(BigDecimal pPercent) {
        this.pPercent = pPercent;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rateId=").append(rateId);
        sb.append(", chargecodeId=").append(chargecodeId);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", courierType=").append(courierType);
        sb.append(", kgdwf=").append(kgdwf);
        sb.append(", kgdwt=").append(kgdwt);
        sb.append(", kgcwf=").append(kgcwf);
        sb.append(", kgcwt=").append(kgcwt);
        sb.append(", meterf=").append(meterf);
        sb.append(", metert=").append(metert);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", cbm=").append(cbm);
        sb.append(", pPiece=").append(pPiece);
        sb.append(", pShipment=").append(pShipment);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", pPercent=").append(pPercent);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}