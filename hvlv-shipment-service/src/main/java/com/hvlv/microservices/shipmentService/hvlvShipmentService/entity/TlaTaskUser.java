package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class TlaTaskUser implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer taskId;

    private Date createTime;

    private Date closeTime;

    private Byte status;

    private Byte isNotice;

    private Integer taskOrder;

    private Integer createUserId;

    private Integer isConfirm;

    private Date eteBk;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Byte isNotice) {
        this.isNotice = isNotice;
    }

    public Integer getTaskOrder() {
        return taskOrder;
    }

    public void setTaskOrder(Integer taskOrder) {
        this.taskOrder = taskOrder;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Integer isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Date getEteBk() {
        return eteBk;
    }

    public void setEteBk(Date eteBk) {
        this.eteBk = eteBk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", taskId=").append(taskId);
        sb.append(", createTime=").append(createTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", status=").append(status);
        sb.append(", isNotice=").append(isNotice);
        sb.append(", taskOrder=").append(taskOrder);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", isConfirm=").append(isConfirm);
        sb.append(", eteBk=").append(eteBk);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}