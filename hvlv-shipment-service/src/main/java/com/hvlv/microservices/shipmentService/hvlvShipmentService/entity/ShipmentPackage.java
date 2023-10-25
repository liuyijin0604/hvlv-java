package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;

public class ShipmentPackage implements Serializable {
    private Integer id;

    private String ref;

    private String cref;

    private Integer userId;

    private Date create;

    private Float weight;

    private Float cbm;

    private Integer pkg;

    private String packages;

    private String pPackages;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getCbm() {
        return cbm;
    }

    public void setCbm(Float cbm) {
        this.cbm = cbm;
    }

    public Integer getPkg() {
        return pkg;
    }

    public void setPkg(Integer pkg) {
        this.pkg = pkg;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getpPackages() {
        return pPackages;
    }

    public void setpPackages(String pPackages) {
        this.pPackages = pPackages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ref=").append(ref);
        sb.append(", cref=").append(cref);
        sb.append(", userId=").append(userId);
        sb.append(", create=").append(create);
        sb.append(", weight=").append(weight);
        sb.append(", cbm=").append(cbm);
        sb.append(", pkg=").append(pkg);
        sb.append(", packages=").append(packages);
        sb.append(", pPackages=").append(pPackages);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}