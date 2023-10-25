package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentRtsRecordConfirm implements Serializable {
    private Integer id;

    private String agentId;

    private String userId;

    private String name;

    private String address;

    private String tel;

    private String suburb;

    private String state;

    private String postcode;

    private String country;

    private String email;

    private Integer status;

    private Integer originalId;

    private Integer newId;

    private Date createTime;

    private Integer rtcGpId;

    private Date rtsDoneTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Integer originalId) {
        this.originalId = originalId;
    }

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRtcGpId() {
        return rtcGpId;
    }

    public void setRtcGpId(Integer rtcGpId) {
        this.rtcGpId = rtcGpId;
    }

    public Date getRtsDoneTime() {
        return rtsDoneTime;
    }

    public void setRtsDoneTime(Date rtsDoneTime) {
        this.rtsDoneTime = rtsDoneTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", agentId=").append(agentId);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", tel=").append(tel);
        sb.append(", suburb=").append(suburb);
        sb.append(", state=").append(state);
        sb.append(", postcode=").append(postcode);
        sb.append(", country=").append(country);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", originalId=").append(originalId);
        sb.append(", newId=").append(newId);
        sb.append(", createTime=").append(createTime);
        sb.append(", rtcGpId=").append(rtcGpId);
        sb.append(", rtsDoneTime=").append(rtsDoneTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}