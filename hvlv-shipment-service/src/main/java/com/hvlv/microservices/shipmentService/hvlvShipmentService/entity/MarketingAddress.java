package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class MarketingAddress implements Serializable {
    private Integer id;

    private String company;

    private String country;

    private String contact;

    private String email;

    private String tel;

    private byte[] imp;

    private byte[] tpl;

    private byte[] tld;

    private byte[] status;

    private String group;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public byte[] getImp() {
        return imp;
    }

    public void setImp(byte[] imp) {
        this.imp = imp;
    }

    public byte[] getTpl() {
        return tpl;
    }

    public void setTpl(byte[] tpl) {
        this.tpl = tpl;
    }

    public byte[] getTld() {
        return tld;
    }

    public void setTld(byte[] tld) {
        this.tld = tld;
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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
        sb.append(", company=").append(company);
        sb.append(", country=").append(country);
        sb.append(", contact=").append(contact);
        sb.append(", email=").append(email);
        sb.append(", tel=").append(tel);
        sb.append(", imp=").append(imp);
        sb.append(", tpl=").append(tpl);
        sb.append(", tld=").append(tld);
        sb.append(", status=").append(status);
        sb.append(", group=").append(group);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}