package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class CargoProcessJob implements Serializable {
    private Integer id;

    private String jobNo;

    private String jobName;

    private String description;

    private Integer status;

    private Date created;

    private Integer dptId;

    private Integer type;

    private Integer userId;

    private Integer driverId;

    private Integer gatePassId;

    private String region;

    private Integer vehicleId;

    private Date compDate;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getGatePassId() {
        return gatePassId;
    }

    public void setGatePassId(Integer gatePassId) {
        this.gatePassId = gatePassId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getCompDate() {
        return compDate;
    }

    public void setCompDate(Date compDate) {
        this.compDate = compDate;
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
        sb.append(", jobNo=").append(jobNo);
        sb.append(", jobName=").append(jobName);
        sb.append(", description=").append(description);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", dptId=").append(dptId);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", driverId=").append(driverId);
        sb.append(", gatePassId=").append(gatePassId);
        sb.append(", region=").append(region);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", compDate=").append(compDate);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}