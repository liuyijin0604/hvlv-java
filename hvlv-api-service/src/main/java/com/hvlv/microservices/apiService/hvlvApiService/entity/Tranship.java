package com.hvlv.microservices.apiService.hvlvApiService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Tranship implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer orgId;

    private Integer manId;

    private String connote;

    private Date time;

    private Byte type;

    private Byte status;

    private BigDecimal cost;

    private String meta;

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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public String getConnote() {
        return connote;
    }

    public void setConnote(String connote) {
        this.connote = connote;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
        sb.append(", pid=").append(pid);
        sb.append(", orgId=").append(orgId);
        sb.append(", manId=").append(manId);
        sb.append(", connote=").append(connote);
        sb.append(", time=").append(time);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", cost=").append(cost);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}