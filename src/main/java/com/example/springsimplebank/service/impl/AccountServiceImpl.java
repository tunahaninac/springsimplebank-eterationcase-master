package com.example.springsimplebank.service.impl;

import com.example.springsimplebank.model.*;
import com.example.springsimplebank.repository.AccountRepository;
import com.example.springsimplebank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

   @Autowired
    private AccountRepository accountRepository;


    @PostConstruct
    public void init() throws InsufficientBalanceException {

    }

    @Override
    public BankAccount debit(double amount)  {
        BankAccount account = new BankAccount("Kerem Karaca","699-7788");
        DepositTransaction depositTransaction = new DepositTransaction(amount);
        depositTransaction.setTransactionStatus("DepositTransaction");
        try {
             account.post(depositTransaction);
             return account;
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
        accountRepository.save(account);
        return account;
    }
    @Override
    public BankAccount credit(double amount)  {
        BankAccount account = new BankAccount("Kerem Karaca","699-7788");
        WithdrawalTransaction wdtransaction= new WithdrawalTransaction(amount);
        wdtransaction.setTransactionStatus("WithdrawalTransaction");
        try {
             account.post(wdtransaction);
            return account;
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }

        return account;
    }

    public BankAccount getAll() {
        BankAccount account = new BankAccount("Kerem Karaca","699-7788");
        DepositTransaction depositTransaction=new DepositTransaction(100);
        try {
            account.post(depositTransaction);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
        accountRepository.save(account);
        return account;
       // return accountRepository.findAll();

    }
    public void deleteAll() {
       accountRepository.deleteAll();

    }
}
