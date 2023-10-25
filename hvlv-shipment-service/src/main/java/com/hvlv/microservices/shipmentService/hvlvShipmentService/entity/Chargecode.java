package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class Chargecode implements Serializable {
    /**
     * key id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * charge code
     *
     * @mbg.generated
     */
    private String code;

    private String name;

    /**
     * charge code description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * type flag:
1 - for import parcel only
2 - for export parcel only
3 - for both
     *
     * @mbg.generated
     */
    private String type;

    private String taxCode;

    private String className;

    private Integer status;

    private Integer dpmt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClass(String className) {
        this.className = className;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDpmt() {
        return dpmt;
    }

    public void setDpmt(Integer dpmt) {
        this.dpmt = dpmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", type=").append(type);
        sb.append(", taxCode=").append(taxCode);
        sb.append(", class=").append(className);
        sb.append(", status=").append(status);
        sb.append(", dpmt=").append(dpmt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}