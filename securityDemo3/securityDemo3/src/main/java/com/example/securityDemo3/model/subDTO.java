package com.example.securityDemo3.model;

import java.time.LocalDate;

public class subDTO {

    private Integer userId;
    private Integer packageId;
    //private LocalDate subscriptionDate = LocalDate.now();

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

    // public LocalDate getSubscriptionDate() {
    //     return subscriptionDate;
    // }

    // public void setSubscriptionDate(LocalDate subscriptionDate) {
    //     this.subscriptionDate = subscriptionDate;
    // }
}
