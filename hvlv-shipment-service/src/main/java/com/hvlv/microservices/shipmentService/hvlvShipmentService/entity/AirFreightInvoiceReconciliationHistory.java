package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class AirFreightInvoiceReconciliationHistory implements Serializable {
    private Integer id;

    private Date created;

    private Integer opId;

    private Integer invoiceTotal;

    private Integer success;

    private Integer failed;

    private Integer attachedFileId;

    private Integer reportFileId;

    private String hash;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Integer getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(Integer invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public Integer getAttachedFileId() {
        return attachedFileId;
    }

    public void setAttachedFileId(Integer attachedFileId) {
        this.attachedFileId = attachedFileId;
    }

    public Integer getReportFileId() {
        return reportFileId;
    }

    public void setReportFileId(Integer reportFileId) {
        this.reportFileId = reportFileId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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
        sb.append(", created=").append(created);
        sb.append(", opId=").append(opId);
        sb.append(", invoiceTotal=").append(invoiceTotal);
        sb.append(", success=").append(success);
        sb.append(", failed=").append(failed);
        sb.append(", attachedFileId=").append(attachedFileId);
        sb.append(", reportFileId=").append(reportFileId);
        sb.append(", hash=").append(hash);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}