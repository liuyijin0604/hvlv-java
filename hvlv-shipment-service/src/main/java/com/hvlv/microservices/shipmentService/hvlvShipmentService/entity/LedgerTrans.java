package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LedgerTrans implements Serializable {
    private Integer id;

    private Integer lid;

    private Integer cra;

    private Integer dea;

    private Date date;

    private Byte status;

    private Byte currency;

    private BigDecimal amount;

    private Byte type;

    private String ref;

    private Integer bwf;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getCra() {
        return cra;
    }

    public void setCra(Integer cra) {
        this.cra = cra;
    }

    public Integer getDea() {
        return dea;
    }

    public void setDea(Integer dea) {
        this.dea = dea;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
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
        sb.append(", lid=").append(lid);
        sb.append(", cra=").append(cra);
        sb.append(", dea=").append(dea);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", currency=").append(currency);
        sb.append(", amount=").append(amount);
        sb.append(", type=").append(type);
        sb.append(", ref=").append(ref);
        sb.append(", bwf=").append(bwf);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}