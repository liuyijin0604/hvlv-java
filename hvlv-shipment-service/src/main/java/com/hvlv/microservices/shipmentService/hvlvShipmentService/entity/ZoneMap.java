package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class ZoneMap implements Serializable {
    private Integer id;

    private Integer orgId;

    private Integer chargecodeId;

    /**
     * org rate related zone id ( org rate based on different zone map needed)
     *
     * @mbg.generated
     */
    private Byte zoneId;

    private String z1;

    private String z2;

    private Integer pcLo;

    private Integer pcHi;

    private String zoneName;

    private String suburb;

    private String state;

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

    public Integer getChargecodeId() {
        return chargecodeId;
    }

    public void setChargecodeId(Integer chargecodeId) {
        this.chargecodeId = chargecodeId;
    }

    public Byte getZoneId() {
        return zoneId;
    }

    public void setZoneId(Byte zoneId) {
        this.zoneId = zoneId;
    }

    public String getZ1() {
        return z1;
    }

    public void setZ1(String z1) {
        this.z1 = z1;
    }

    public String getZ2() {
        return z2;
    }

    public void setZ2(String z2) {
        this.z2 = z2;
    }

    public Integer getPcLo() {
        return pcLo;
    }

    public void setPcLo(Integer pcLo) {
        this.pcLo = pcLo;
    }

    public Integer getPcHi() {
        return pcHi;
    }

    public void setPcHi(Integer pcHi) {
        this.pcHi = pcHi;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgId=").append(orgId);
        sb.append(", chargecodeId=").append(chargecodeId);
        sb.append(", zoneId=").append(zoneId);
        sb.append(", z1=").append(z1);
        sb.append(", z2=").append(z2);
        sb.append(", pcLo=").append(pcLo);
        sb.append(", pcHi=").append(pcHi);
        sb.append(", zoneName=").append(zoneName);
        sb.append(", suburb=").append(suburb);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}