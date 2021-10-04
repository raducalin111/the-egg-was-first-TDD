package com.auto.transactions.impl;

import com.auto.dao.AppointmentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAppointmentTransactionTest {

    @Mock
    AppointmentDao appointmentDao;

    @InjectMocks
    CreateAppointmentTransaction transaction;

    @Test
    public void executeValidCreatesAppointment() {
        transaction.setName("Calin");
        transaction.setCarBrand("Audi");
        transaction.setTime(LocalDateTime.of(2021, Month.OCTOBER, 12, 12, 0));

        transaction.execute();

        verify(appointmentDao).add(any());
    }

    @Test
    public void dateInPastIsNotValid() {
        transaction.setName("Calin");
        transaction.setCarBrand("Audi");
        transaction.setTime(LocalDateTime.of(2021, Month.SEPTEMBER, 22, 14, 20));

        assertFalse(transaction.validate());
    }

    @Test
    public void dateInFutureIsValid() {
        transaction.setName("Calin");
        transaction.setCarBrand("Audi");
        transaction.setTime(LocalDateTime.of(2021, Month.OCTOBER, 22, 14, 20));

        assertTrue(transaction.validate());
    }

    @Test(expected = IllegalStateException.class)
    public void executeInvalidThrowsException() {
        transaction.setName("Calin");
        transaction.setTime(LocalDateTime.of(2021, Month.DECEMBER, 29, 12, 0));

        transaction.execute();
    }


}
