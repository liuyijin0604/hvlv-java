package com.hvlv.microservices.shipmentService.hvlvShipmentService.entity;

import java.io.Serializable;

public class SalesfunnelRequirementsSubmission implements Serializable {
    private Integer id;

    private String companyName;

    private String firstName;

    private String lastName;

    private String email;

    private Integer contactNumber;

    private Integer status;

    private String password;

    private String category;

    private Integer forwarderShippingagent;

    private Integer customerType;

    private Integer subStatus;

    private Integer subStatusIgnore;

    private String businessRequirement;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getForwarderShippingagent() {
        return forwarderShippingagent;
    }

    public void setForwarderShippingagent(Integer forwarderShippingagent) {
        this.forwarderShippingagent = forwarderShippingagent;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public Integer getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(Integer subStatus) {
        this.subStatus = subStatus;
    }

    public Integer getSubStatusIgnore() {
        return subStatusIgnore;
    }

    public void setSubStatusIgnore(Integer subStatusIgnore) {
        this.subStatusIgnore = subStatusIgnore;
    }

    public String getBusinessRequirement() {
        return businessRequirement;
    }

    public void setBusinessRequirement(String businessRequirement) {
        this.businessRequirement = businessRequirement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyName=").append(companyName);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", status=").append(status);
        sb.append(", password=").append(password);
        sb.append(", category=").append(category);
        sb.append(", forwarderShippingagent=").append(forwarderShippingagent);
        sb.append(", customerType=").append(customerType);
        sb.append(", subStatus=").append(subStatus);
        sb.append(", subStatusIgnore=").append(subStatusIgnore);
        sb.append(", businessRequirement=").append(businessRequirement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}