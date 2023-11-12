package com.example.springsimplebank.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Transactions")
public abstract class Transaction {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(columnDefinition = "BINARY(16)")
    private UUID transactionid;

    @Column(name = "date")
    public Date date;

    @Column(name = "amount")
    @JSONField(name = "amount")
    public double amount;

    @Column(name = "type")
    public String type;

    @Column(name = "transactionStatus")
    private String transactionStatus;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    @JsonIgnore
    private BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    public Transaction(double amount) {
        this.transactionid = UUID.randomUUID();
        this.amount = amount;
        this.date = new Date();
        this.type = this.getClass().getSimpleName();
    }

    public abstract void doTransaction(BankAccount account) throws InsufficientBalanceException;

    public Transaction() {
    }

    public UUID getTransactionid() {
        return transactionid;
    }

    public Date getDate() {
        return date;
    }


    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String toString() {
        return "Transaction [date =" + date + ", amount =" + amount + "]";
    }

}

