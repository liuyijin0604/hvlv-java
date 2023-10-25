package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentProcess extends MetaModel implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer status;

    private Integer consolId;

    private Integer sAgentId;

    private Integer sBwf;

    private String consolEta;

    private byte[] type;

    private Integer brokerId;

    private Date started;

    private Date date;

    private String meta;

    private String noticeContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getConsolId() {
        return consolId;
    }

    public void setConsolId(Integer consolId) {
        this.consolId = consolId;
    }

    public Integer getsAgentId() {
        return sAgentId;
    }

    public void setsAgentId(Integer sAgentId) {
        this.sAgentId = sAgentId;
    }

    public Integer getsBwf() {
        return sBwf;
    }

    public void setsBwf(Integer sBwf) {
        this.sBwf = sBwf;
    }

    public String getConsolEta() {
        return consolEta;
    }

    public void setConsolEta(String consolEta) {
        this.consolEta = consolEta;
    }

    public byte[] getType() {
        return type;
    }

    public void setType(byte[] type) {
        this.type = type;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", status=").append(status);
        sb.append(", consolId=").append(consolId);
        sb.append(", sAgentId=").append(sAgentId);
        sb.append(", sBwf=").append(sBwf);
        sb.append(", consolEta=").append(consolEta);
        sb.append(", type=").append(type);
        sb.append(", brokerId=").append(brokerId);
        sb.append(", started=").append(started);
        sb.append(", date=").append(date);
        sb.append(", meta=").append(meta);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}