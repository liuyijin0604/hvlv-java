package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ChangeShipmentLabel implements Serializable {
    private Integer id;

    private String pref;

    private String phbn;

    private String newref;

    private Integer isCopy;

    private Integer pid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getPhbn() {
        return phbn;
    }

    public void setPhbn(String phbn) {
        this.phbn = phbn;
    }

    public String getNewref() {
        return newref;
    }

    public void setNewref(String newref) {
        this.newref = newref;
    }

    public Integer getIsCopy() {
        return isCopy;
    }

    public void setIsCopy(Integer isCopy) {
        this.isCopy = isCopy;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pref=").append(pref);
        sb.append(", phbn=").append(phbn);
        sb.append(", newref=").append(newref);
        sb.append(", isCopy=").append(isCopy);
        sb.append(", pid=").append(pid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}