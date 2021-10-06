package com.auto.model;

import java.math.BigDecimal;

public class Product {

    private long id;
    private String serviceName;
    private int approximateDuration;
    private BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getApproximateDuration() {
        return approximateDuration;
    }

    public void setApproximateDuration(int approximateDuration) {
        this.approximateDuration = approximateDuration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
