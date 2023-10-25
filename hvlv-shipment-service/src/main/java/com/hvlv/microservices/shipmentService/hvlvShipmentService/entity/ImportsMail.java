package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ImportsMail implements Serializable {
    private Integer id;

    private Integer linkId;

    private Integer type;

    private String no;

    private String fromEmail;

    private String fromName;

    private String toEmail;

    private String toName;

    private Integer opId;

    private String ccEmail;

    private Integer uid;

    private Date createTime;

    private Date date;

    private Byte status;

    private byte[] flag;

    private Byte fromFlag;

    private Integer is3pl;

    private String ticket;

    private String subject;

    private String plainBody;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
    }

    public Byte getFromFlag() {
        return fromFlag;
    }

    public void setFromFlag(Byte fromFlag) {
        this.fromFlag = fromFlag;
    }

    public Integer getIs3pl() {
        return is3pl;
    }

    public void setIs3pl(Integer is3pl) {
        this.is3pl = is3pl;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPlainBody() {
        return plainBody;
    }

    public void setPlainBody(String plainBody) {
        this.plainBody = plainBody;
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
        sb.append(", linkId=").append(linkId);
        sb.append(", type=").append(type);
        sb.append(", no=").append(no);
        sb.append(", fromEmail=").append(fromEmail);
        sb.append(", fromName=").append(fromName);
        sb.append(", toEmail=").append(toEmail);
        sb.append(", toName=").append(toName);
        sb.append(", opId=").append(opId);
        sb.append(", ccEmail=").append(ccEmail);
        sb.append(", uid=").append(uid);
        sb.append(", createTime=").append(createTime);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", flag=").append(flag);
        sb.append(", fromFlag=").append(fromFlag);
        sb.append(", is3pl=").append(is3pl);
        sb.append(", ticket=").append(ticket);
        sb.append(", subject=").append(subject);
        sb.append(", plainBody=").append(plainBody);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}