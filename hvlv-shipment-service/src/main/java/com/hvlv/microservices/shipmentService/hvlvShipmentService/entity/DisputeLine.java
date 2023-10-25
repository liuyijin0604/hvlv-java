package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class DisputeLine implements Serializable {
    private Integer id;

    private Integer type;

    private Integer status;

    private Byte flag;

    private Integer disputeId;

    private Integer siReconcileLineId;

    private BigDecimal disputeAmountExGst;

    private BigDecimal creditAmountExGst;

    private Integer dpmt;

    private String meta;

    private String note;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public Integer getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(Integer disputeId) {
        this.disputeId = disputeId;
    }

    public Integer getSiReconcileLineId() {
        return siReconcileLineId;
    }

    public void setSiReconcileLineId(Integer siReconcileLineId) {
        this.siReconcileLineId = siReconcileLineId;
    }

    public BigDecimal getDisputeAmountExGst() {
        return disputeAmountExGst;
    }

    public void setDisputeAmountExGst(BigDecimal disputeAmountExGst) {
        this.disputeAmountExGst = disputeAmountExGst;
    }

    public BigDecimal getCreditAmountExGst() {
        return creditAmountExGst;
    }

    public void setCreditAmountExGst(BigDecimal creditAmountExGst) {
        this.creditAmountExGst = creditAmountExGst;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", flag=").append(flag);
        sb.append(", disputeId=").append(disputeId);
        sb.append(", siReconcileLineId=").append(siReconcileLineId);
        sb.append(", disputeAmountExGst=").append(disputeAmountExGst);
        sb.append(", creditAmountExGst=").append(creditAmountExGst);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", meta=").append(meta);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}