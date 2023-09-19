package com.example.springjpa.service;

import com.example.springjpa.exception.BankErrorCode;
import com.example.springjpa.model.AllLog;
import com.example.springjpa.repository.AllLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoggingService {
    @Autowired
    AllLogRepo allLogRepo;
    @Transactional(propagation  = Propagation.REQUIRES_NEW)
    public void saveLog(long fromAccId, long toAccId, long amount, BankErrorCode bankErrorCode, String detail){
        AllLog allLog = new AllLog(fromAccId,toAccId,amount,bankErrorCode,detail);
        allLogRepo.save(allLog);
    }
}
