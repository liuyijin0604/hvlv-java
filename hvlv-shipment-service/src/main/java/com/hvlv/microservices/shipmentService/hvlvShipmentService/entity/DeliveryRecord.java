package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class DeliveryRecord implements Serializable {
    private Integer id;

    private String rego;

    private Integer plt;

    private Byte status;

    private Byte damage;

    private Integer opId;

    private Date created;

    private String task;

    private String no;

    private Date bookingTime;

    private String mobile;

    private String name;

    private Integer pkg;

    private String uuid;

    private String note;

    private String meta;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public Integer getPlt() {
        return plt;
    }

    public void setPlt(Integer plt) {
        this.plt = plt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDamage() {
        return damage;
    }

    public void setDamage(Byte damage) {
        this.damage = damage;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPkg() {
        return pkg;
    }

    public void setPkg(Integer pkg) {
        this.pkg = pkg;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        sb.append(", rego=").append(rego);
        sb.append(", plt=").append(plt);
        sb.append(", status=").append(status);
        sb.append(", damage=").append(damage);
        sb.append(", opId=").append(opId);
        sb.append(", created=").append(created);
        sb.append(", task=").append(task);
        sb.append(", no=").append(no);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append(", mobile=").append(mobile);
        sb.append(", name=").append(name);
        sb.append(", pkg=").append(pkg);
        sb.append(", uuid=").append(uuid);
        sb.append(", note=").append(note);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}