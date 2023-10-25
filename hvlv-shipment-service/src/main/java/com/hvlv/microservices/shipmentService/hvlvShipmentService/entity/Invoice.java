package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Invoice implements Serializable {
    private Integer id;

    private Integer toId;

    private Integer consolId;

    private Integer pid;

    private Integer jobId;

    private Integer cgOrderId;

    private Integer manId;

    private Integer dptId;

    private Byte dpmt;

    private Byte status;

    private Byte type;

    private Byte currency;

    private Byte sent;

    private String no;

    private String ref;

    private Integer bflag;

    private Date date;

    private Date due;

    private Date posted;

    private BigDecimal total;

    private BigDecimal gst;

    private Byte syncXero;

    private String xeroId;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getConsolId() {
        return consolId;
    }

    public void setConsolId(Integer consolId) {
        this.consolId = consolId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getCgOrderId() {
        return cgOrderId;
    }

    public void setCgOrderId(Integer cgOrderId) {
        this.cgOrderId = cgOrderId;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Byte getDpmt() {
        return dpmt;
    }

    public void setDpmt(Byte dpmt) {
        this.dpmt = dpmt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public Byte getSent() {
        return sent;
    }

    public void setSent(Byte sent) {
        this.sent = sent;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getBflag() {
        return bflag;
    }

    public void setBflag(Integer bflag) {
        this.bflag = bflag;
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

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
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

    public Byte getSyncXero() {
        return syncXero;
    }

    public void setSyncXero(Byte syncXero) {
        this.syncXero = syncXero;
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
        sb.append(", toId=").append(toId);
        sb.append(", consolId=").append(consolId);
        sb.append(", pid=").append(pid);
        sb.append(", jobId=").append(jobId);
        sb.append(", cgOrderId=").append(cgOrderId);
        sb.append(", manId=").append(manId);
        sb.append(", dptId=").append(dptId);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", currency=").append(currency);
        sb.append(", sent=").append(sent);
        sb.append(", no=").append(no);
        sb.append(", ref=").append(ref);
        sb.append(", bflag=").append(bflag);
        sb.append(", date=").append(date);
        sb.append(", due=").append(due);
        sb.append(", posted=").append(posted);
        sb.append(", total=").append(total);
        sb.append(", gst=").append(gst);
        sb.append(", syncXero=").append(syncXero);
        sb.append(", xeroId=").append(xeroId);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}