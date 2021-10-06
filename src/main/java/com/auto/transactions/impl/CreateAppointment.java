package com.auto.transactions.impl;

import com.auto.dao.AppointmentDao;
import com.auto.model.Appointment;
import com.auto.transactions.Transaction;

import java.time.LocalDateTime;

public class CreateAppointment implements Transaction {

    private String name;
    private LocalDateTime time;
    private String carBrand;

    private AppointmentDao appointmentDao;


    @Override
    public boolean validate() {
        if (carBrand == null) {
            return false;
        }

        if (LocalDateTime.now().isAfter(time)) {
            return false;
        }

        return true;
    }

    @Override
    public void execute() {
        if(!validate()) {
            throw new IllegalStateException("The appointment is not valid!");
        }

        appointmentDao.create(new Appointment(this));
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

    public void setAppointmentDao(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }
}
