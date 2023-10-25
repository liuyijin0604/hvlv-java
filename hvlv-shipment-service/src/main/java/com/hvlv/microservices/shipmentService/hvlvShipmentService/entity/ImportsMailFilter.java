package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ImportsMailFilter implements Serializable {
    private Integer id;

    private String fromEmail;

    private String fromName;

    private String subject;

    private String toEmail;

    private String ccEmail;

    private Integer type;

    private String tel;

    private String note;

    private Integer is3pl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getIs3pl() {
        return is3pl;
    }

    public void setIs3pl(Integer is3pl) {
        this.is3pl = is3pl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fromEmail=").append(fromEmail);
        sb.append(", fromName=").append(fromName);
        sb.append(", subject=").append(subject);
        sb.append(", toEmail=").append(toEmail);
        sb.append(", ccEmail=").append(ccEmail);
        sb.append(", type=").append(type);
        sb.append(", tel=").append(tel);
        sb.append(", note=").append(note);
        sb.append(", is3pl=").append(is3pl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}