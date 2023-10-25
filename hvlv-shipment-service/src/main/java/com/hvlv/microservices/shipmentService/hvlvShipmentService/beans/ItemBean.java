package com.hvlv.microservices.shipmentService.hvlvShipmentService.beans;

public class ItemBean {
    private String type;
    private String name;
    private String nameZh;
    private String brand;
    private String model;
    private int qty;
    private double price;
    private String hs;
    private String sku;

    // Getters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public String getHs() {
        return hs;
    }

    public String getSku() {
        return sku;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHs(String hs) {
        this.hs = hs;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
