package com.example.springsimplebank.responses;
import com.example.springsimplebank.model.BankAccount;

public class SuccessResponse extends Result{
    public SuccessResponse(BankAccount account){
        super("OK");
    }
    public SuccessResponse(String message){

        super("OK","OK");
    }
}