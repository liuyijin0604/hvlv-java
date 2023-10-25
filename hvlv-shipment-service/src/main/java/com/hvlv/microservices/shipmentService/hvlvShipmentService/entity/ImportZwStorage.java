package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImportZwStorage implements Serializable {
    private Integer id;

    private String putcode;

    private String tlano;

    private String memberid;

    private String storeCode;

    private String arrivalCity;

    private Integer transportType;

    private String channelCode;

    private BigDecimal volume;

    private BigDecimal weight;

    private Date arrivalDate;

    private Date created;

    private Date updated;

    private Integer orgId;

    private Integer clientId;

    private Date cutday;

    private Integer goodsCount;

    private String remark;

    private Integer status;

    private String meta;

    private String items;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPutcode() {
        return putcode;
    }

    public void setPutcode(String putcode) {
        this.putcode = putcode;
    }

    public String getTlano() {
        return tlano;
    }

    public void setTlano(String tlano) {
        this.tlano = tlano;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Integer getTransportType() {
        return transportType;
    }

    public void setTransportType(Integer transportType) {
        this.transportType = transportType;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getCutday() {
        return cutday;
    }

    public void setCutday(Date cutday) {
        this.cutday = cutday;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", putcode=").append(putcode);
        sb.append(", tlano=").append(tlano);
        sb.append(", memberid=").append(memberid);
        sb.append(", storeCode=").append(storeCode);
        sb.append(", arrivalCity=").append(arrivalCity);
        sb.append(", transportType=").append(transportType);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", volume=").append(volume);
        sb.append(", weight=").append(weight);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", orgId=").append(orgId);
        sb.append(", clientId=").append(clientId);
        sb.append(", cutday=").append(cutday);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", meta=").append(meta);
        sb.append(", items=").append(items);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}