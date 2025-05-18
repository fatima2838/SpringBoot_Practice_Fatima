package com.example.securityDemo3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MobilePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer dataAmount;
    private double price; // Added price field

    // Default constructor
    public MobilePackage() {
    }

    // All-args constructor, including price
    public MobilePackage(Integer id, String name, Integer dataAmount, double price) {
        this.id = id;
        this.name = name;
        this.dataAmount = dataAmount;
        this.price = price;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(Integer dataAmount) {
        this.dataAmount = dataAmount;
    }

    public double getPrice() {  // Getter for price
        return price;
    }

    public void setPrice(double price) {  // Setter for price
        this.price = price;
    }

    @Override
    public String toString() {
        return "MobilePackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataAmount=" + dataAmount +
                ", price=" + price +  // Added price to toString
                '}';
    }
}
