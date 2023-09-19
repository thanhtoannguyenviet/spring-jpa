package com.example.springjpa.service;

import com.example.springjpa.model.Account;
import com.example.springjpa.model.TransactLog;
import com.example.springjpa.repository.TransactLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactLogService {
    @Autowired
    TransactLogRepo transactLogRepo;
    @Transactional(propagation  = Propagation.MANDATORY)
    public void saveTransactLog(long amount, Account fromAccount, Account toAccount){
        TransactLog transactLog = new TransactLog(fromAccount,toAccount,amount);
        transactLogRepo.save(transactLog);
    }
}
