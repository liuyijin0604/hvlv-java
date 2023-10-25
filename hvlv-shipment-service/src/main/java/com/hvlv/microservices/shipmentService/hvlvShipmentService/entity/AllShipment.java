package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AllShipment implements Serializable {
    private Integer id;

    private Integer ownerId;

    private Integer agentId;

    private Integer consolId;

    private Integer manId;

    private Integer recId;

    private Integer odptId;

    private Integer ddptId;

    private Integer cnorId;

    private Integer cneeId;

    private Integer receiverId;

    private Integer notifyId;

    private Integer zrId;

    private Integer otId;

    private Byte status;

    private Byte type;

    private Byte styp;

    private byte[] pickup;

    private String hbn;

    private String ref;

    private String cref;

    private Integer pkg;

    private String state;

    private String postcode;

    private BigDecimal value;

    private BigDecimal dvalue;

    private Float tariff;

    private Float insurance;

    private Byte currency;

    private BigDecimal weight;

    private BigDecimal wtck;

    private BigDecimal cbm;

    private byte[] sac;

    private String exm;

    private String can;

    private Integer bwf;

    private Integer cbwf;

    private Date created;

    private Integer scanNo;

    private String packages;

    private String items;

    private String meta;

    private String scan;

    private String note;

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

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getConsolId() {
        return consolId;
    }

    public void setConsolId(Integer consolId) {
        this.consolId = consolId;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getOdptId() {
        return odptId;
    }

    public void setOdptId(Integer odptId) {
        this.odptId = odptId;
    }

    public Integer getDdptId() {
        return ddptId;
    }

    public void setDdptId(Integer ddptId) {
        this.ddptId = ddptId;
    }

    public Integer getCnorId() {
        return cnorId;
    }

    public void setCnorId(Integer cnorId) {
        this.cnorId = cnorId;
    }

    public Integer getCneeId() {
        return cneeId;
    }

    public void setCneeId(Integer cneeId) {
        this.cneeId = cneeId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Integer notifyId) {
        this.notifyId = notifyId;
    }

    public Integer getZrId() {
        return zrId;
    }

    public void setZrId(Integer zrId) {
        this.zrId = zrId;
    }

    public Integer getOtId() {
        return otId;
    }

    public void setOtId(Integer otId) {
        this.otId = otId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStyp() {
        return styp;
    }

    public void setStyp(Byte styp) {
        this.styp = styp;
    }

    public byte[] getPickup() {
        return pickup;
    }

    public void setPickup(byte[] pickup) {
        this.pickup = pickup;
    }

    public String getHbn() {
        return hbn;
    }

    public void setHbn(String hbn) {
        this.hbn = hbn;
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

    public Integer getPkg() {
        return pkg;
    }

    public void setPkg(Integer pkg) {
        this.pkg = pkg;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getDvalue() {
        return dvalue;
    }

    public void setDvalue(BigDecimal dvalue) {
        this.dvalue = dvalue;
    }

    public Float getTariff() {
        return tariff;
    }

    public void setTariff(Float tariff) {
        this.tariff = tariff;
    }

    public Float getInsurance() {
        return insurance;
    }

    public void setInsurance(Float insurance) {
        this.insurance = insurance;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWtck() {
        return wtck;
    }

    public void setWtck(BigDecimal wtck) {
        this.wtck = wtck;
    }

    public BigDecimal getCbm() {
        return cbm;
    }

    public void setCbm(BigDecimal cbm) {
        this.cbm = cbm;
    }

    public byte[] getSac() {
        return sac;
    }

    public void setSac(byte[] sac) {
        this.sac = sac;
    }

    public String getExm() {
        return exm;
    }

    public void setExm(String exm) {
        this.exm = exm;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    public Integer getBwf() {
        return bwf;
    }

    public void setBwf(Integer bwf) {
        this.bwf = bwf;
    }

    public Integer getCbwf() {
        return cbwf;
    }

    public void setCbwf(Integer cbwf) {
        this.cbwf = cbwf;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getScanNo() {
        return scanNo;
    }

    public void setScanNo(Integer scanNo) {
        this.scanNo = scanNo;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", agentId=").append(agentId);
        sb.append(", consolId=").append(consolId);
        sb.append(", manId=").append(manId);
        sb.append(", recId=").append(recId);
        sb.append(", odptId=").append(odptId);
        sb.append(", ddptId=").append(ddptId);
        sb.append(", cnorId=").append(cnorId);
        sb.append(", cneeId=").append(cneeId);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", notifyId=").append(notifyId);
        sb.append(", zrId=").append(zrId);
        sb.append(", otId=").append(otId);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", styp=").append(styp);
        sb.append(", pickup=").append(pickup);
        sb.append(", hbn=").append(hbn);
        sb.append(", ref=").append(ref);
        sb.append(", cref=").append(cref);
        sb.append(", pkg=").append(pkg);
        sb.append(", state=").append(state);
        sb.append(", postcode=").append(postcode);
        sb.append(", value=").append(value);
        sb.append(", dvalue=").append(dvalue);
        sb.append(", tariff=").append(tariff);
        sb.append(", insurance=").append(insurance);
        sb.append(", currency=").append(currency);
        sb.append(", weight=").append(weight);
        sb.append(", wtck=").append(wtck);
        sb.append(", cbm=").append(cbm);
        sb.append(", sac=").append(sac);
        sb.append(", exm=").append(exm);
        sb.append(", can=").append(can);
        sb.append(", bwf=").append(bwf);
        sb.append(", cbwf=").append(cbwf);
        sb.append(", created=").append(created);
        sb.append(", scanNo=").append(scanNo);
        sb.append(", packages=").append(packages);
        sb.append(", items=").append(items);
        sb.append(", meta=").append(meta);
        sb.append(", scan=").append(scan);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}