package com.auto.transactions.impl;

import com.auto.dao.InvoiceDao;
import com.auto.model.Invoice;
import com.auto.model.Product;
import com.auto.transactions.Transaction;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CreateInvoice implements Transaction {

    private List<Product> products;
    private String email;
    private String clientName;

    private InvoiceDao invoiceDao;

    @Override
    public boolean validate() {
       if(products.size() < 1) {
          return false;
       }

       if(StringUtils.isAnyEmpty(email, clientName)) {
           return false;
       }

       return true;
    }

    @Override
    public void execute() {
        if(!validate()) {
            throw new IllegalStateException("Invoice cannot be created!");
        }

        Invoice invoice = new Invoice();
        invoice.setProducts(products);
        invoice.setEmail(email);
        invoice.setClientName(clientName);

        invoiceDao.create(invoice);
    }

    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
