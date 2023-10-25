package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Billing1 implements Serializable {
    private Integer id;

    private Integer orgId;

    private Date created;

    private Date date;

    private Date due;

    private Date transactionDate;

    private Byte type;

    private Integer dpmt;

    private Byte status;

    private String billingCref;

    private String billingRef;

    private Integer dptId;

    private byte[] currency;

    private String no;

    private Byte syncXero;

    private BigDecimal total;

    private BigDecimal gst;

    private String xeroId;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBillingCref() {
        return billingCref;
    }

    public void setBillingCref(String billingCref) {
        this.billingCref = billingCref;
    }

    public String getBillingRef() {
        return billingRef;
    }

    public void setBillingRef(String billingRef) {
        this.billingRef = billingRef;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public byte[] getCurrency() {
        return currency;
    }

    public void setCurrency(byte[] currency) {
        this.currency = currency;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Byte getSyncXero() {
        return syncXero;
    }

    public void setSyncXero(Byte syncXero) {
        this.syncXero = syncXero;
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

    public String getXeroId() {
        return xeroId;
    }

    public void setXeroId(String xeroId) {
        this.xeroId = xeroId;
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
        sb.append(", date=").append(date);
        sb.append(", due=").append(due);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", type=").append(type);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", status=").append(status);
        sb.append(", billingCref=").append(billingCref);
        sb.append(", billingRef=").append(billingRef);
        sb.append(", dptId=").append(dptId);
        sb.append(", currency=").append(currency);
        sb.append(", no=").append(no);
        sb.append(", syncXero=").append(syncXero);
        sb.append(", total=").append(total);
        sb.append(", gst=").append(gst);
        sb.append(", xeroId=").append(xeroId);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}