package com.example.securityDemo3.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private Integer userId;
    private Integer packageId;
    private LocalDate date;

    // Constructors
    public Subscription() {}

    public Subscription(Integer userId, Integer packageId, LocalDate date) {
        this.userId = userId;
        this.packageId = packageId;
        this.date = date;
    }

    public Subscription(Long serviceId, Integer userId, Integer packageId, LocalDate date) {
        this.serviceId = serviceId;
        this.userId = userId;
        this.packageId = packageId;
        this.date = date;
    }

    // Getters and Setters
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
