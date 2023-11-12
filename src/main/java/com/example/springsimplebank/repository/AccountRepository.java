package com.example.springsimplebank.repository;

import com.example.springsimplebank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
     Optional<BankAccount> findById(String s);
}
