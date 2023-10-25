package com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Shipment {
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
     private Integer status;
     private Integer type;
     private Integer styp;
     private Integer pickup;
     private String hbn;
     private String ref;
     private String cref;
     private Integer pkg;
     private String packages;
     private String items;
     private String state;
     private String postcode;
     private Double value;
     private Double dvalue;
     private Double tariff;
     private Double insurance;
     private Integer currency;
     private Double weight;
     private Double wtck;
     private Double cbm;
     private Integer sac;
     private String exm;
     private String can;
     private Integer bwf;
     private Integer cbwf;
     private String meta;
     private String scan;
     private String note;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    private Integer scanNo;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStyp() {
        return styp;
    }

    public void setStyp(Integer styp) {
        this.styp = styp;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getDvalue() {
        return dvalue;
    }

    public void setDvalue(Double dvalue) {
        this.dvalue = dvalue;
    }

    public Double getTariff() {
        return tariff;
    }

    public void setTariff(Double tariff) {
        this.tariff = tariff;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWtck() {
        return wtck;
    }

    public void setWtck(Double wtck) {
        this.wtck = wtck;
    }

    public Double getCbm() {
        return cbm;
    }

    public void setCbm(Double cbm) {
        this.cbm = cbm;
    }

    public Integer getSac() {
        return sac;
    }

    public void setSac(Integer sac) {
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
}


