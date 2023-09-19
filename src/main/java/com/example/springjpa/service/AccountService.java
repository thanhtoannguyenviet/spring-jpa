package com.example.springjpa.service;

import com.example.springjpa.model.Account;
import com.example.springjpa.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Page<Account> searchAccountByName(String name, Pageable pageable){
        return accountRepo.findAllByOwner(name,pageable);
    }
}
