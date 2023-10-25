package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class Org implements Serializable {
    public static final Integer ORGID_COURIER_AUPOST = 101;
    private Integer id;

    private Integer pid;

    private Integer type;

    private String name;

    private String code;

    private String accode;

    private String abn;

    private String address;

    private String suburb;

    private String state;

    private String postcode;

    private String country;

    private String email;

    private String phone;

    private String fax;

    private byte[] status;

    private Integer by;

    private Integer manager;

    private Integer nln;

    private Integer cargoDriverType;

    private String hash;

    private Float lat;

    private Float lng;

    private String desc;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccode() {
        return accode;
    }

    public void setAccode(String accode) {
        this.accode = accode;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }

    public Integer getBy() {
        return by;
    }

    public void setBy(Integer by) {
        this.by = by;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Integer getNln() {
        return nln;
    }

    public void setNln(Integer nln) {
        this.nln = nln;
    }

    public Integer getCargoDriverType() {
        return cargoDriverType;
    }

    public void setCargoDriverType(Integer cargoDriverType) {
        this.cargoDriverType = cargoDriverType;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", accode=").append(accode);
        sb.append(", abn=").append(abn);
        sb.append(", address=").append(address);
        sb.append(", suburb=").append(suburb);
        sb.append(", state=").append(state);
        sb.append(", postcode=").append(postcode);
        sb.append(", country=").append(country);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", fax=").append(fax);
        sb.append(", status=").append(status);
        sb.append(", by=").append(by);
        sb.append(", manager=").append(manager);
        sb.append(", nln=").append(nln);
        sb.append(", cargoDriverType=").append(cargoDriverType);
        sb.append(", hash=").append(hash);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", desc=").append(desc);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}