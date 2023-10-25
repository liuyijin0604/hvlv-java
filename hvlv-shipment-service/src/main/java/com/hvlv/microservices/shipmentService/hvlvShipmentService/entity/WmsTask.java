package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class WmsTask implements Serializable {
    private Integer id;

    private Integer jobId;

    private Integer opId;

    private Integer linkId;

    private Short type;

    private Byte status;

    private byte[] isRequest;

    private byte[] billed;

    private String ref;

    private Date dueTime;

    private Date schdTime;

    private Date startTime;

    private Date complTime;

    private Integer bwf;

    private String meta;

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

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public byte[] getIsRequest() {
        return isRequest;
    }

    public void setIsRequest(byte[] isRequest) {
        this.isRequest = isRequest;
    }

    public byte[] getBilled() {
        return billed;
    }

    public void setBilled(byte[] billed) {
        this.billed = billed;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Date getSchdTime() {
        return schdTime;
    }

    public void setSchdTime(Date schdTime) {
        this.schdTime = schdTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getComplTime() {
        return complTime;
    }

    public void setComplTime(Date complTime) {
        this.complTime = complTime;
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
        sb.append(", jobId=").append(jobId);
        sb.append(", opId=").append(opId);
        sb.append(", linkId=").append(linkId);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", isRequest=").append(isRequest);
        sb.append(", billed=").append(billed);
        sb.append(", ref=").append(ref);
        sb.append(", dueTime=").append(dueTime);
        sb.append(", schdTime=").append(schdTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", complTime=").append(complTime);
        sb.append(", bwf=").append(bwf);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}