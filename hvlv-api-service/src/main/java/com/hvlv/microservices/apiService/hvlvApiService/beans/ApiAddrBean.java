package com.hvlv.microservices.apiService.hvlvApiService.beans;

public class ApiAddrBean {
    private Integer id;

    private Integer ownerId;

    private Integer cnidId;

    private String name;

    private String company;

    private String suburb;

    private String city;

    private String state;

    private String postcode;

    private String country;

    private String tel;

    private String email;

    private Byte acc;

    private String cnidNo;

    private String address;

    private String cref;

    private Boolean is3PL;

    private Integer dptId;

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

    public Integer getCnidId() {
        return cnidId;
    }

    public void setCnidId(Integer cnidId) {
        this.cnidId = cnidId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getAcc() {
        return acc;
    }

    public void setAcc(Byte acc) {
        this.acc = acc;
    }

    public String getCnidNo() {
        return cnidNo;
    }

    public void setCnidNo(String cnidNo) {
        this.cnidNo = cnidNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getCref() {
        return cref;
    }

    public Boolean getIs3PL() {
        return is3PL;
    }

    public void setIs3PL(Boolean is3PL) {
        this.is3PL = is3PL;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }
    public Integer getDptId() {
        return dptId;
    }
}
