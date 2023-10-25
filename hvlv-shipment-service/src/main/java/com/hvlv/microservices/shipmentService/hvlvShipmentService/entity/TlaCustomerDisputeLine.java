package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TlaCustomerDisputeLine implements Serializable {
    private Integer id;

    private Integer parentId;

    private Integer invId;

    private String invNo;

    private String ref;

    private Integer pid;

    private BigDecimal invoiceAmount;

    private BigDecimal customerAmount;

    private BigDecimal diff;

    private String disputeType;

    private String tlaOpComment;

    private String creditNoteNo;

    private BigDecimal creditNoteAmount;

    private String comment;

    private Integer status;

    private Date created;

    private Integer handleStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigDecimal getCustomerAmount() {
        return customerAmount;
    }

    public void setCustomerAmount(BigDecimal customerAmount) {
        this.customerAmount = customerAmount;
    }

    public BigDecimal getDiff() {
        return diff;
    }

    public void setDiff(BigDecimal diff) {
        this.diff = diff;
    }

    public String getDisputeType() {
        return disputeType;
    }

    public void setDisputeType(String disputeType) {
        this.disputeType = disputeType;
    }

    public String getTlaOpComment() {
        return tlaOpComment;
    }

    public void setTlaOpComment(String tlaOpComment) {
        this.tlaOpComment = tlaOpComment;
    }

    public String getCreditNoteNo() {
        return creditNoteNo;
    }

    public void setCreditNoteNo(String creditNoteNo) {
        this.creditNoteNo = creditNoteNo;
    }

    public BigDecimal getCreditNoteAmount() {
        return creditNoteAmount;
    }

    public void setCreditNoteAmount(BigDecimal creditNoteAmount) {
        this.creditNoteAmount = creditNoteAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", invId=").append(invId);
        sb.append(", invNo=").append(invNo);
        sb.append(", ref=").append(ref);
        sb.append(", pid=").append(pid);
        sb.append(", invoiceAmount=").append(invoiceAmount);
        sb.append(", customerAmount=").append(customerAmount);
        sb.append(", diff=").append(diff);
        sb.append(", disputeType=").append(disputeType);
        sb.append(", tlaOpComment=").append(tlaOpComment);
        sb.append(", creditNoteNo=").append(creditNoteNo);
        sb.append(", creditNoteAmount=").append(creditNoteAmount);
        sb.append(", comment=").append(comment);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", handleStatus=").append(handleStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}