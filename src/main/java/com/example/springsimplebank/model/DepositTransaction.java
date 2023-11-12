package com.example.springsimplebank.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;


public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    public DepositTransaction() {
    }

    @Override
    public void doTransaction(BankAccount account) {
        account.deposit(super.getAmount());
    }

}