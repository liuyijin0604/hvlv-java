package com.hvlv.microservices.shipmentService.hvlvShipmentService.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ApiShipmentBean {
    private Integer id;
    private Integer owner_id;
    private Integer agent_id;
    private Integer consol_id;
    private Integer man_id;
    private Integer rec_id;
    private Integer odpt_id;
    private Integer ddpt_id;
    private Integer cnor_id;
    private Integer cnee_id;
    private Integer receiver_id;
    private Integer notify_id;
    private Integer zr_id;
    private Integer ot_id;
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
    private Date created;
    private Integer scan_no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Integer agent_id) {
        this.agent_id = agent_id;
    }

    public Integer getConsol_id() {
        return consol_id;
    }

    public void setConsol_id(Integer consol_id) {
        this.consol_id = consol_id;
    }

    public Integer getMan_id() {
        return man_id;
    }

    public void setMan_id(Integer man_id) {
        this.man_id = man_id;
    }

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public Integer getOdpt_id() {
        return odpt_id;
    }

    public void setOdpt_id(Integer odpt_id) {
        this.odpt_id = odpt_id;
    }

    public Integer getDdpt_id() {
        return ddpt_id;
    }

    public void setDdpt_id(Integer ddpt_id) {
        this.ddpt_id = ddpt_id;
    }

    public Integer getCnor_id() {
        return cnor_id;
    }

    public void setCnor_id(Integer cnor_id) {
        this.cnor_id = cnor_id;
    }

    public Integer getCnee_id() {
        return cnee_id;
    }

    public void setCnee_id(Integer cnee_id) {
        this.cnee_id = cnee_id;
    }

    public Integer getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Integer receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Integer getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(Integer notify_id) {
        this.notify_id = notify_id;
    }

    public Integer getZr_id() {
        return zr_id;
    }

    public void setZr_id(Integer zr_id) {
        this.zr_id = zr_id;
    }

    public Integer getOt_id() {
        return ot_id;
    }

    public void setOt_id(Integer ot_id) {
        this.ot_id = ot_id;
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

    public Integer getScan_no() {
        return scan_no;
    }

    public void setScan_no(Integer scan_no) {
        this.scan_no = scan_no;
    }

    @Override
    public String toString() {
        return "ApiShipmentBean{" +
                "id='" + id + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", agent_id='" + agent_id + '\'' +
                ", consol_id='" + consol_id + '\'' +
                ", man_id='" + man_id + '\'' +
                ", rec_id='" + rec_id + '\'' +
                ", odpt_id=" + odpt_id +
                ", ddpt_id=" + ddpt_id +
                ", cnor_id=" + cnor_id +
                ", cnee_id=" + cnee_id +
                ", receiver_id=" + receiver_id +
                ", notify_id=" + notify_id +
                ", zr_id=" + zr_id +
                ", ot_id=" + ot_id +
                ", status=" + status +
                ", type=" + type +
                ", styp=" + styp +
                ", pickup=" + pickup +
                ", hbn='" + hbn + '\'' +
                ", ref='" + ref + '\'' +
                ", cref='" + cref + '\'' +
                ", pkg=" + pkg +
                ", packages='" + packages + '\'' +
                ", items='" + items + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", value=" + value +
                ", dvalue=" + dvalue +
                ", tariff=" + tariff +
                ", insurance=" + insurance +
                ", currency=" + currency +
                ", weight=" + weight +
                ", wtck=" + wtck +
                ", cbm=" + cbm +
                ", sac=" + sac +
                ", exm='" + exm + '\'' +
                ", can='" + can + '\'' +
                ", bwf=" + bwf +
                ", cbwf=" + cbwf +
                ", meta='" + meta + '\'' +
                ", scan='" + scan + '\'' +
                ", note='" + note + '\'' +
                ", created=" + created +
                ", scan_no=" + scan_no +
                '}';
    }
}
