package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Reconciliation implements Serializable {
    private Integer id;

    private Integer clientType;

    private String invoiceNo;

    private Date invoiceDate;

    private String manifestNo;

    private BigDecimal invoiceTotal;

    private BigDecimal myTotal;

    private Byte flag;

    private String noConsol;

    private String notype;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getManifestNo() {
        return manifestNo;
    }

    public void setManifestNo(String manifestNo) {
        this.manifestNo = manifestNo;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getMyTotal() {
        return myTotal;
    }

    public void setMyTotal(BigDecimal myTotal) {
        this.myTotal = myTotal;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getNoConsol() {
        return noConsol;
    }

    public void setNoConsol(String noConsol) {
        this.noConsol = noConsol;
    }

    public String getNotype() {
        return notype;
    }

    public void setNotype(String notype) {
        this.notype = notype;
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
        sb.append(", clientType=").append(clientType);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", manifestNo=").append(manifestNo);
        sb.append(", invoiceTotal=").append(invoiceTotal);
        sb.append(", myTotal=").append(myTotal);
        sb.append(", flag=").append(flag);
        sb.append(", noConsol=").append(noConsol);
        sb.append(", notype=").append(notype);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}