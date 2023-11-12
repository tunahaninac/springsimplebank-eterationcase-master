package com.example.springsimplebank.responses;

public class Result {
    private String status;
    private String approvelCode;
    public Result(String status){
        this.status = status;
    }
    public Result(String approvelCode, String status){
        this(approvelCode);
        this.status = status;
    }
    public String getMessage(){
        return this.status;
    }
}