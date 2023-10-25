package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class DfeChangeLabel implements Serializable {
    private Integer id;

    private String dfeRef;

    private Integer sn;

    private String alliedRef;

    private Integer pid;

    private Date create;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDfeRef() {
        return dfeRef;
    }

    public void setDfeRef(String dfeRef) {
        this.dfeRef = dfeRef;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getAlliedRef() {
        return alliedRef;
    }

    public void setAlliedRef(String alliedRef) {
        this.alliedRef = alliedRef;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dfeRef=").append(dfeRef);
        sb.append(", sn=").append(sn);
        sb.append(", alliedRef=").append(alliedRef);
        sb.append(", pid=").append(pid);
        sb.append(", create=").append(create);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}