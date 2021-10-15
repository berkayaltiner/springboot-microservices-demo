package com.microservicedemo.accountservice.service;

import com.microservicedemo.accountservice.entity.Account;
import com.microservicedemo.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Account> getAll() {return accountRepository.findAll();}

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Account update(String id, Account account){
        Assert.isNull(id,"id can't be null");
        return accountRepository.save(account);
    }

    public void delete(String id){

    }

}
