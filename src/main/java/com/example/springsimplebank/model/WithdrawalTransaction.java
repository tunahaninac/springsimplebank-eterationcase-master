package com.example.springsimplebank.model;

import javax.persistence.Entity;


public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    public WithdrawalTransaction() {
    }
    @Override
    public void doTransaction(BankAccount account) throws InsufficientBalanceException {
        account.withdraw(super.getAmount());
    }


}
