package com.example.springsimplebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="owner" )
    public String owner;
    @Column(name ="accountnumber" )
    public String accountNumber;
    @Column(name ="balance" )
    public BigDecimal balance;
    @Column(name ="createddate" )
    public Date cdate;

    /* @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonIgnore
    */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bankAccount", cascade = CascadeType.ALL)
     List<Transaction> transactions;

    public BankAccount() {

    }
    public BankAccount(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.cdate=new Date();
        this.transactions = new ArrayList<>();
        this.balance = new BigDecimal(0);
    }



    public void deposit(double d) {

        balance = balance.add(BigDecimal.valueOf(d));
    }
    public void withdraw(double d) throws InsufficientBalanceException {
        if (balance.subtract(BigDecimal.valueOf(d)).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance = balance.subtract(BigDecimal.valueOf(d));

    }
    public UUID post(Transaction transaction) throws InsufficientBalanceException {
        try {
            transaction.doTransaction(this);
            transaction.setTransactionStatus(GeneralEnumerationDefinitions.TransactionStatus.OK.getShortCode());
        } catch (InsufficientBalanceException e) {
            transaction.setTransactionStatus(GeneralEnumerationDefinitions.TransactionStatus.ERROR.getShortCode());
            throw e;
        } finally {
            transactions.add(transaction);
        }
        return transaction.getTransactionid();
    }


}
