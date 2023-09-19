package com.example.springjpa.controller;

import com.example.springjpa.model.Account;
import com.example.springjpa.repository.AccountRepo;
import com.example.springjpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping
    public ResponseEntity<?> getAccount(@RequestParam("search")String search, Pageable pageable){
        Page<Account> accountList = accountService.searchAccountByName(search, pageable);
        return ResponseEntity.ok(accountList);
    }
}
