package com.example.springjpa.controller;

import com.example.springjpa.dto.TransferRequest;
import com.example.springjpa.dto.TransferResult;
import com.example.springjpa.exception.BankException;
import com.example.springjpa.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping("/transfer")
    public ResponseEntity<TransferResult> transfer(@ModelAttribute TransferRequest transferRequest){
        try{
            TransferResult result = bankService.transfer(
                    transferRequest.getAccountFrom(),
                    transferRequest.getAccountTo(),
                    transferRequest.getAmount()
            );
            return ResponseEntity.ok(result);
        }catch (BankException e){
            TransferResult transerError = new TransferResult(
                    e.getStatus(),
                    e.getMessage()+ " : " + e.getDetail(),
                    new Date()
            );
            return ResponseEntity.badRequest().body(transerError);
        }
    }
}
