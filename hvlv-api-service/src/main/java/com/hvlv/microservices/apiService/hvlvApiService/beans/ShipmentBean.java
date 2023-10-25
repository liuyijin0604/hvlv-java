package com.hvlv.microservices.apiService.hvlvApiService.beans;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

public class ShipmentBean {
    private Integer id;
    private JSONObject mdata;
    private double charge_wt;
    private double weight;
    private double cbm;
    private double charge_cbm;
    private String chargecode;
    //private int cnee;
    private int Pkg;
    private Byte currency;
    private BigDecimal dvalue;
    private String cref;
    private String hbn;
    private String ref;
    private Integer cbwf;
    private String no;
    private int agent_id;
    private JSONObject meta;
    private String address;
    private JSONArray packages;
    private int packs;
    private Addr cnee;
    public JSONObject getMdata()
    {
     return mdata;
    }

    public void setMdata(JSONObject mdata) {
        this.mdata = mdata;
    }

    public double getCharge_wt() {
        return charge_wt;
    }

    public void setCharge_wt(double charge_wt) {
        this.charge_wt = charge_wt;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCbm() {
        return cbm;
    }

    public void setCbm(double cbm) {
        this.cbm = cbm;
    }

    public String getChargecode() {
        return chargecode;
    }

    public void setChargecode(String chargecode) {
        this.chargecode = chargecode;
    }

    public double getCharge_cbm() {
        return charge_cbm;
    }

    public void setCharge_cbm(double charge_cbm) {
        this.charge_cbm = charge_cbm;
    }

    public Addr getCnee() {
        return cnee;
    }

    public void setCnee(Addr cnee) {
        this.cnee = cnee;
    }

    public int getPkg() {
        return Pkg;
    }

    public void setPkg(int pkg) {
        Pkg = pkg;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public BigDecimal getDvalue() {
        return dvalue;
    }

    public void setDvalue(BigDecimal dvalue) {
        this.dvalue = dvalue;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
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

    public Integer getCbwf() {
        return cbwf;
    }

    public void setCbwf(Integer cbwf) {
        this.cbwf = cbwf;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public JSONObject getMeta() {
        return meta;
    }
    public void setMeta(JSONObject meta) {
        this.meta = meta;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPackages(JSONArray packages) {
        this.packages = packages;
    }

    public JSONArray getPackages() {
        return packages;
    }

    public void setPacks(int packs) {
        this.packs = packs;
    }

    public int getPacks() {
        return packs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
