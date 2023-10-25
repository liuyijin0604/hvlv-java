package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class AddrArchive implements Serializable {
    private Integer id;

    private Integer ownerId;

    private Integer cnidId;

    private String name;

    private String company;

    private String suburb;

    private String city;

    private String state;

    private String postcode;

    private String country;

    private String tel;

    private String email;

    private Byte acc;

    private String cnidNo;

    private String address;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCnidId() {
        return cnidId;
    }

    public void setCnidId(Integer cnidId) {
        this.cnidId = cnidId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public Byte getAcc() {
        return acc;
    }

    public void setAcc(Byte acc) {
        this.acc = acc;
    }

    public String getCnidNo() {
        return cnidNo;
    }

    public void setCnidNo(String cnidNo) {
        this.cnidNo = cnidNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", cnidId=").append(cnidId);
        sb.append(", name=").append(name);
        sb.append(", company=").append(company);
        sb.append(", suburb=").append(suburb);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append(", postcode=").append(postcode);
        sb.append(", country=").append(country);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", acc=").append(acc);
        sb.append(", cnidNo=").append(cnidNo);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}