package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class OrgContact implements Serializable {
    private Integer id;

    private Integer orgId;

    private Byte type;

    private String name;

    private String position;

    private String address;

    private String suburb;

    private String city;

    private String state;

    private String postcode;

    private String country;

    private String email;

    private String phone;

    private String direct;

    private String mobile;

    private String fax;

    private String accode;

    private Integer func;

    private byte[] status;

    private String desc;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAccode() {
        return accode;
    }

    public void setAccode(String accode) {
        this.accode = accode;
    }

    public Integer getFunc() {
        return func;
    }

    public void setFunc(Integer func) {
        this.func = func;
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
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
        sb.append(", orgId=").append(orgId);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", position=").append(position);
        sb.append(", address=").append(address);
        sb.append(", suburb=").append(suburb);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append(", postcode=").append(postcode);
        sb.append(", country=").append(country);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", direct=").append(direct);
        sb.append(", mobile=").append(mobile);
        sb.append(", fax=").append(fax);
        sb.append(", accode=").append(accode);
        sb.append(", func=").append(func);
        sb.append(", status=").append(status);
        sb.append(", desc=").append(desc);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}