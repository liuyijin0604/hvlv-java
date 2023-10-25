package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PriceEnquiry implements Serializable {
    private Integer id;

    private Integer status;

    private Date date;

    private String code;

    private BigDecimal cost;

    private BigDecimal price;

    private String address;

    private Double weight;

    private Double length;

    private Double width;

    private Double height;

    private Integer quantity;

    private String note;

    private String suburb;

    private String postcode;

    private String dangerousGoods;

    private String chargeCode;

    private String name;

    private String tel;

    private String email;

    private String category;

    private String depot;

    private String addressType;

    private Integer orgId;

    private String paidBy;

    private String mannualUnloading;

    private String tailgateUnloading;

    private String meta;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDangerousGoods() {
        return dangerousGoods;
    }

    public void setDangerousGoods(String dangerousGoods) {
        this.dangerousGoods = dangerousGoods;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDepot() {
        return depot;
    }

    public void setDepot(String depot) {
        this.depot = depot;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getMannualUnloading() {
        return mannualUnloading;
    }

    public void setMannualUnloading(String mannualUnloading) {
        this.mannualUnloading = mannualUnloading;
    }

    public String getTailgateUnloading() {
        return tailgateUnloading;
    }

    public void setTailgateUnloading(String tailgateUnloading) {
        this.tailgateUnloading = tailgateUnloading;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", date=").append(date);
        sb.append(", code=").append(code);
        sb.append(", cost=").append(cost);
        sb.append(", price=").append(price);
        sb.append(", address=").append(address);
        sb.append(", weight=").append(weight);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", quantity=").append(quantity);
        sb.append(", note=").append(note);
        sb.append(", suburb=").append(suburb);
        sb.append(", postcode=").append(postcode);
        sb.append(", dangerousGoods=").append(dangerousGoods);
        sb.append(", chargeCode=").append(chargeCode);
        sb.append(", name=").append(name);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", category=").append(category);
        sb.append(", depot=").append(depot);
        sb.append(", addressType=").append(addressType);
        sb.append(", orgId=").append(orgId);
        sb.append(", paidBy=").append(paidBy);
        sb.append(", mannualUnloading=").append(mannualUnloading);
        sb.append(", tailgateUnloading=").append(tailgateUnloading);
        sb.append(", meta=").append(meta);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}