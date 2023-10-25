package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class JobLine implements Serializable {
    private Integer id;

    private Integer jobId;

    private String ccode;

    private String desc;

    private BigDecimal qty;

    private BigDecimal rate;

    private String invGst;

    private Integer supplierId;

    private String invoiceRef;

    private Date invoiceDate;

    private Date invoiceDueDate;

    private BigDecimal costAmount;

    private String costGst;

    private Integer invlineId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getInvGst() {
        return invGst;
    }

    public void setInvGst(String invGst) {
        this.invGst = invGst;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public String getCostGst() {
        return costGst;
    }

    public void setCostGst(String costGst) {
        this.costGst = costGst;
    }

    public Integer getInvlineId() {
        return invlineId;
    }

    public void setInvlineId(Integer invlineId) {
        this.invlineId = invlineId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobId=").append(jobId);
        sb.append(", ccode=").append(ccode);
        sb.append(", desc=").append(desc);
        sb.append(", qty=").append(qty);
        sb.append(", rate=").append(rate);
        sb.append(", invGst=").append(invGst);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", invoiceRef=").append(invoiceRef);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", invoiceDueDate=").append(invoiceDueDate);
        sb.append(", costAmount=").append(costAmount);
        sb.append(", costGst=").append(costGst);
        sb.append(", invlineId=").append(invlineId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}