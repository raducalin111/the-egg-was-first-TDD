package com.auto.transactions.impl;

import com.auto.dao.AppointmentDao;
import com.auto.transactions.Transaction;

import java.time.LocalDateTime;

public class CreateAppointmentTransaction implements Transaction {

    private String name;
    private LocalDateTime time;
    private String carBrand;

    private AppointmentDao appointmentDao;


    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void execute() {

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

    public AppointmentDao getAppointmentDao() {
        return appointmentDao;
    }

    public void setAppointmentDao(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }
}
