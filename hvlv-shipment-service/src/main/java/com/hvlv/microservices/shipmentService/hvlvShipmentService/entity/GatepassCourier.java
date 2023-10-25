package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class GatepassCourier implements Serializable {
    private Integer id;

    private String no;

    private Integer type;

    private Integer courierId;

    private String driverName;

    private String driverRego;

    private String ref;

    private Date createTime;

    private Byte status;

    private Integer userId;

    private Integer driverLicenseId;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverRego() {
        return driverRego;
    }

    public void setDriverRego(String driverRego) {
        this.driverRego = driverRego;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDriverLicenseId() {
        return driverLicenseId;
    }

    public void setDriverLicenseId(Integer driverLicenseId) {
        this.driverLicenseId = driverLicenseId;
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
        sb.append(", no=").append(no);
        sb.append(", type=").append(type);
        sb.append(", courierId=").append(courierId);
        sb.append(", driverName=").append(driverName);
        sb.append(", driverRego=").append(driverRego);
        sb.append(", ref=").append(ref);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", driverLicenseId=").append(driverLicenseId);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}