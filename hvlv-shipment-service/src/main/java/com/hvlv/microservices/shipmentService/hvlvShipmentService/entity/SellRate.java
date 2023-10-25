package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SellRate implements Serializable {
    private Integer id;

    private Integer orgId;

    private Integer byId;

    private String code;

    private Byte type;

    private Date vfrom;

    private Date vto;

    private Byte currency;

    private BigDecimal wtLo;

    private BigDecimal wtHi;

    private BigDecimal base;

    private BigDecimal item;

    private BigDecimal perkg;

    private BigDecimal nkg;

    private BigDecimal min;

    private byte[] gst;

    private BigDecimal levy;

    private String meta;

    private static final long serialVersionUID = 1L;

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

    public Integer getById() {
        return byId;
    }

    public void setById(Integer byId) {
        this.byId = byId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getVfrom() {
        return vfrom;
    }

    public void setVfrom(Date vfrom) {
        this.vfrom = vfrom;
    }

    public Date getVto() {
        return vto;
    }

    public void setVto(Date vto) {
        this.vto = vto;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public BigDecimal getWtLo() {
        return wtLo;
    }

    public void setWtLo(BigDecimal wtLo) {
        this.wtLo = wtLo;
    }

    public BigDecimal getWtHi() {
        return wtHi;
    }

    public void setWtHi(BigDecimal wtHi) {
        this.wtHi = wtHi;
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

    public BigDecimal getNkg() {
        return nkg;
    }

    public void setNkg(BigDecimal nkg) {
        this.nkg = nkg;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
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
        sb.append(", orgId=").append(orgId);
        sb.append(", byId=").append(byId);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", vfrom=").append(vfrom);
        sb.append(", vto=").append(vto);
        sb.append(", currency=").append(currency);
        sb.append(", wtLo=").append(wtLo);
        sb.append(", wtHi=").append(wtHi);
        sb.append(", base=").append(base);
        sb.append(", item=").append(item);
        sb.append(", perkg=").append(perkg);
        sb.append(", nkg=").append(nkg);
        sb.append(", min=").append(min);
        sb.append(", gst=").append(gst);
        sb.append(", levy=").append(levy);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}