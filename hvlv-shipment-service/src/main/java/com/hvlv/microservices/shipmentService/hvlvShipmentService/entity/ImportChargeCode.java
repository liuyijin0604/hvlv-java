package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ImportChargeCode extends MetaModel implements Serializable {
    private Integer id;

    private Integer orgId;

    private byte[] type;

    /**
     * charge code random 6 digital

     *
     * @mbg.generated
     */
    private String chargecode;

    /**
     * save courier list as json format
     *
     * @mbg.generated
     */
    private String couriers;

    /**
     * charge code created time 
     *
     * @mbg.generated
     */
    private Date created;

    /**
     * 0 - disable
1 - enable
     *
     * @mbg.generated
     */
    private Byte status;

    private Integer chargeWt;

    /**
     * used to determine the status after consol
     *
     * @mbg.generated
     */
    private Byte statusMode;

    private byte[] ignoreSac;

    /**
     * charge code validation from what time
     *
     * @mbg.generated
     */
    private Date vFrom;

    /**
     * charge code validation to what time
     *
     * @mbg.generated
     */
    private Date vTo;

    /**
     * note information
     *
     * @mbg.generated
     */
    private String note;

    private Integer dpmt;

    private String description;

    private String meta;

    private static final long serialVersionUID = 1L;

    public static final Set<String> AUPOST_CODES = new HashSet<>();

    static {
        AUPOST_CODES.add("au_post_eparcel_2019");
        AUPOST_CODES.add("aupost_express");
        AUPOST_CODES.add("au_post_eparcel_mel");
        AUPOST_CODES.add("au_post_eparcel_bri");
        AUPOST_CODES.add("au_post_eparcel_per");
        AUPOST_CODES.add("AuBigLetter");
        AUPOST_CODES.add("AuBigLetter"); // This entry is repeated in your original list
        AUPOST_CODES.add("PriorityBigLetter");
        AUPOST_CODES.add("PrioritySmallLetter");
        AUPOST_CODES.add("UBI_TOLL_SYD");
        AUPOST_CODES.add("UBI_TOLL_MEL");
        AUPOST_CODES.add("UBI_TOLL_BNE");
        AUPOST_CODES.add("UBI_TOLL_PER");
        AUPOST_CODES.add("UBI_TOLL_ADL"); // There is no direct mapping for UBI_ADL_CODE in your provided list
        AUPOST_CODES.add("pickup_only");
        AUPOST_CODES.add("GV_eparcel_syd");
        AUPOST_CODES.add("GV_eparcel_mel");
        AUPOST_CODES.add("GV_eparcel_bne");
        AUPOST_CODES.add("GV_eparcel_per");
        AUPOST_CODES.add("GV_eparcel_mel_2022");
        AUPOST_CODES.add("pickup_non_ref");
        AUPOST_CODES.add("aupost_return");
    }

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

    public byte[] getType() {
        return type;
    }

    public void setType(byte[] type) {
        this.type = type;
    }

    public String getChargecode() {
        return chargecode;
    }

    public void setChargecode(String chargecode) {
        this.chargecode = chargecode;
    }

    public String getCouriers() {
        return couriers;
    }

    public void setCouriers(String couriers) {
        this.couriers = couriers;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getChargeWt() {
        return chargeWt;
    }

    public void setChargeWt(int chargeWt) {
        this.chargeWt = chargeWt;
    }

    public Byte getStatusMode() {
        return statusMode;
    }

    public void setStatusMode(Byte statusMode) {
        this.statusMode = statusMode;
    }

    public byte[] getIgnoreSac() {
        return ignoreSac;
    }

    public void setIgnoreSac(byte[] ignoreSac) {
        this.ignoreSac = ignoreSac;
    }

    public Date getvFrom() {
        return vFrom;
    }

    public void setvFrom(Date vFrom) {
        this.vFrom = vFrom;
    }

    public Date getvTo() {
        return vTo;
    }

    public void setvTo(Date vTo) {
        this.vTo = vTo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        sb.append(", chargecode=").append(chargecode);
        sb.append(", couriers=").append(couriers);
        sb.append(", created=").append(created);
        sb.append(", status=").append(status);
        sb.append(", chargeWt=").append(chargeWt);
        sb.append(", statusMode=").append(statusMode);
        sb.append(", ignoreSac=").append(ignoreSac);
        sb.append(", vFrom=").append(vFrom);
        sb.append(", vTo=").append(vTo);
        sb.append(", note=").append(note);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", description=").append(description);
        sb.append(", meta=").append(meta);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}