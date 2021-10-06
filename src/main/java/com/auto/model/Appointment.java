package com.auto.model;


import com.auto.transactions.impl.CreateAppointment;

import java.time.LocalDateTime;

public class Appointment {
    private String name;
    private LocalDateTime time;
    private String carBrand;

    public Appointment(CreateAppointment transaction) {
        this.name = transaction.getName();
        this.time = transaction.getTime();
        this.carBrand = transaction.getCarBrand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}
