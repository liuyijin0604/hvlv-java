package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Quotes implements Serializable {
    private Integer id;

    private Integer routeId;

    private String uldType;

    private Integer wtLo;

    private Integer wtHi;

    private BigDecimal pkg;

    private BigDecimal min;

    private Date dateEff;

    private Date dateExp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getUldType() {
        return uldType;
    }

    public void setUldType(String uldType) {
        this.uldType = uldType;
    }

    public Integer getWtLo() {
        return wtLo;
    }

    public void setWtLo(Integer wtLo) {
        this.wtLo = wtLo;
    }

    public Integer getWtHi() {
        return wtHi;
    }

    public void setWtHi(Integer wtHi) {
        this.wtHi = wtHi;
    }

    public BigDecimal getPkg() {
        return pkg;
    }

    public void setPkg(BigDecimal pkg) {
        this.pkg = pkg;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public Date getDateEff() {
        return dateEff;
    }

    public void setDateEff(Date dateEff) {
        this.dateEff = dateEff;
    }

    public Date getDateExp() {
        return dateExp;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", routeId=").append(routeId);
        sb.append(", uldType=").append(uldType);
        sb.append(", wtLo=").append(wtLo);
        sb.append(", wtHi=").append(wtHi);
        sb.append(", pkg=").append(pkg);
        sb.append(", min=").append(min);
        sb.append(", dateEff=").append(dateEff);
        sb.append(", dateExp=").append(dateExp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}