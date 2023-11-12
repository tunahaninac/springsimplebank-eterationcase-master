package com.example.springsimplebank.responses;

public class ErrorResponse extends Result {
    public ErrorResponse(){
        super("NOT OK");
    }
    public ErrorResponse(String message){
        super("undefined", "NOT OK");
    }

}