package com.hvlv.microservices.shipmentClusterService.hvlvShipmentClusterService.beans;

public class UserBean {
    private Integer id;
    private String email;
    private String password;
    private String fname;

    public UserBean(Integer id, String email, String password, String fname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fname = fname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fname='" + fname + '\'' +
                '}';
    }
}