package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZoneRateBk implements Serializable {
    private Integer id;

    private Integer rateId;

    private Integer chargecodeId;

    private String zone;

    private String zoneName;

    private BigDecimal weightLo;

    private BigDecimal weightHi;

    private BigDecimal base;

    private BigDecimal item;

    private BigDecimal perkg;

    private Float nkg;

    private BigDecimal minimum;

    private byte[] gst;

    private BigDecimal levy;

    private BigDecimal minIncl;

    private Integer version;

    private Integer createUser;

    private Date startDate;

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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public BigDecimal getWeightLo() {
        return weightLo;
    }

    public void setWeightLo(BigDecimal weightLo) {
        this.weightLo = weightLo;
    }

    public BigDecimal getWeightHi() {
        return weightHi;
    }

    public void setWeightHi(BigDecimal weightHi) {
        this.weightHi = weightHi;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getItem() {
        return item;
    }

    public void setItem(BigDecimal item) {
        this.item = item;
    }

    public BigDecimal getPerkg() {
        return perkg;
    }

    public void setPerkg(BigDecimal perkg) {
        this.perkg = perkg;
    }

    public Float getNkg() {
        return nkg;
    }

    public void setNkg(Float nkg) {
        this.nkg = nkg;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public byte[] getGst() {
        return gst;
    }

    public void setGst(byte[] gst) {
        this.gst = gst;
    }

    public BigDecimal getLevy() {
        return levy;
    }

    public void setLevy(BigDecimal levy) {
        this.levy = levy;
    }

    public BigDecimal getMinIncl() {
        return minIncl;
    }

    public void setMinIncl(BigDecimal minIncl) {
        this.minIncl = minIncl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        sb.append(", zone=").append(zone);
        sb.append(", zoneName=").append(zoneName);
        sb.append(", weightLo=").append(weightLo);
        sb.append(", weightHi=").append(weightHi);
        sb.append(", base=").append(base);
        sb.append(", item=").append(item);
        sb.append(", perkg=").append(perkg);
        sb.append(", nkg=").append(nkg);
        sb.append(", minimum=").append(minimum);
        sb.append(", gst=").append(gst);
        sb.append(", levy=").append(levy);
        sb.append(", minIncl=").append(minIncl);
        sb.append(", version=").append(version);
        sb.append(", createUser=").append(createUser);
        sb.append(", startDate=").append(startDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}