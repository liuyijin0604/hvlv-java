package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupplierInvoice implements Serializable {
    private Integer id;

    private Integer orgId;

    private Date created;

    private Date invDate;

    private Byte type;

    private Byte status;

    private String invNo;

    private byte[] currency;

    private BigDecimal total;

    private BigDecimal gst;

    private BigDecimal totalExGst;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public byte[] getCurrency() {
        return currency;
    }

    public void setCurrency(byte[] currency) {
        this.currency = currency;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public BigDecimal getTotalExGst() {
        return totalExGst;
    }

    public void setTotalExGst(BigDecimal totalExGst) {
        this.totalExGst = totalExGst;
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
        sb.append(", created=").append(created);
        sb.append(", invDate=").append(invDate);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", invNo=").append(invNo);
        sb.append(", currency=").append(currency);
        sb.append(", total=").append(total);
        sb.append(", gst=").append(gst);
        sb.append(", totalExGst=").append(totalExGst);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}