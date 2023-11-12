package com.example.springsimplebank.controller;


import com.example.springsimplebank.dto.AmountRequestDto;
import com.example.springsimplebank.model.BankAccount;
import com.example.springsimplebank.model.InsufficientBalanceException;
import com.example.springsimplebank.repository.AccountRepository;
import com.example.springsimplebank.responses.Result;
import com.example.springsimplebank.responses.SuccessResponse;
import com.example.springsimplebank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

   @Autowired
   private  AccountService accountService;
    AccountRepository accountRepository;

    @GetMapping
    public BankAccount getAccount() {
        BankAccount account = accountService.getAll();
        return account;
    }

    @PostMapping("/credit")
    public ResponseEntity<Result> credit(@RequestBody AmountRequestDto amountRequestDto) throws InsufficientBalanceException {
        try{
            BankAccount account = accountService.credit(amountRequestDto.getAmount());
            return new  ResponseEntity<>(new SuccessResponse(account), HttpStatus.OK);
        }catch (InsufficientBalanceException e){
            throw e ;
        }
    }
    @PostMapping("/debit")
    public BankAccount debit(@RequestBody AmountRequestDto amountRequestDto) throws InsufficientBalanceException {
        try{
            BankAccount account = accountService.debit(amountRequestDto.getAmount());
            return account;
        }catch (InsufficientBalanceException e){
            throw e ;
        }

    }
    @GetMapping("credit")
    public BankAccount deneme(){
        BankAccount account = new BankAccount();
        return account;
    }

    @DeleteMapping
    public void deleteAllAccounts(){
        accountService.deleteAll();
    }
}

