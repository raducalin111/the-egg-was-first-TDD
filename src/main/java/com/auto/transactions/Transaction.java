package com.auto.transactions;

public interface Transaction {
    boolean validate();
    void execute();
}
