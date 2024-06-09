package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer laptopid;
    private String model;
    private double price;
    private Integer sid;

    public Laptops(){

    }

    public Laptops(String model, double price, Integer sid) {
        this.model = model;
        this.price = price;
        this.sid = sid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
