package com.hvlv.microservices.apiService.hvlvApiService.entity;

import java.io.Serializable;
import java.util.Date;

public class OrgRate implements Serializable {
    private Integer id;

    private Integer orgId;

    /**
     * save rate related zone map id
     *
     * @mbg.generated
     */
    private Byte zoneId;

    private String name;

    private String code;

    private Byte type;

    private Date vfrom;

    private Date vto;

    private Byte currency;

    private Date updated;

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

    public Byte getZoneId() {
        return zoneId;
    }

    public void setZoneId(Byte zoneId) {
        this.zoneId = zoneId;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getVfrom() {
        return vfrom;
    }

    public void setVfrom(Date vfrom) {
        this.vfrom = vfrom;
    }

    public Date getVto() {
        return vto;
    }

    public void setVto(Date vto) {
        this.vto = vto;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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
        sb.append(", zoneId=").append(zoneId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", vfrom=").append(vfrom);
        sb.append(", vto=").append(vto);
        sb.append(", currency=").append(currency);
        sb.append(", updated=").append(updated);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}