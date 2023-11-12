package com.example.springsimplebank.service;

import com.example.springsimplebank.model.BankAccount;
import com.example.springsimplebank.model.InsufficientBalanceException;

public interface AccountService {

    BankAccount getAll();
    BankAccount credit(double amount) throws InsufficientBalanceException;
    BankAccount debit(double amount) throws InsufficientBalanceException, InsufficientBalanceException;
    void deleteAll();
}

