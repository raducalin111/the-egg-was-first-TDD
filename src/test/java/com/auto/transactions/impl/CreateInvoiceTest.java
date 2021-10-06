package com.auto.transactions.impl;

import com.auto.dao.InvoiceDao;
import com.auto.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateInvoiceTest {

    @Mock
    List<Product> productList;

    @Mock
    InvoiceDao invoiceDao;

    @InjectMocks
    CreateInvoice createInvoice;


    @Test
    public void validInvoiceIsCreated() {
        when(productList.size()).thenReturn(2);
        createInvoice.setEmail("test@auto.com");
        createInvoice.setClientName("Test Client");

        createInvoice.execute();
        verify(invoiceDao).create(any());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotCreateInvoiceFromEmptyList() {
        when(productList.size()).thenReturn(0);
        createInvoice.setEmail("test@auto.com");
        createInvoice.setClientName("Test Client");

        createInvoice.execute();
    }

    @Test
    public void emptyListIsInvalid() {
        when(productList.size()).thenReturn(0);
        createInvoice.setEmail("test@auto.com");
        createInvoice.setClientName("Test Client");

        assertFalse(createInvoice.validate());
    }

    @Test
    public void emptyEmailIsInvalid() {
        when(productList.size()).thenReturn(2);
        createInvoice.setEmail("");
        createInvoice.setClientName("Test Client");

        assertFalse(createInvoice.validate());
    }

}
