package com.example.springjpa.service;

import com.example.springjpa.dto.TransferResult;
import com.example.springjpa.exception.AccountException;
import com.example.springjpa.exception.BankErrorCode;
import com.example.springjpa.exception.BankException;
import com.example.springjpa.model.Account;
import com.example.springjpa.repository.AccountRepo;
import com.example.springjpa.repository.TransactLogRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankService {
    @Autowired
    TransactLogService transactLogService;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    LoggingService loggingService;

    //rollbackOn: khi BankException xay ra, se duoc rollback lai. Do saveLog co @Transaction REQUIRE_NEW nên saveLog sẻ tự
    //tạo 1 transaction khác không liên quan đến Transaction đang thực thi -> saveLog vẫn sẻ lưu lại
    @Transactional(rollbackOn = {BankException.class})
    public TransferResult transfer(long fromAccId, long toAccId, long amount){
        Account fromAccount = accountRepo.getById(fromAccId);
        Account toAccount = accountRepo.getById(toAccId);

        if (fromAccount.getBalance()<amount){
            String detail = "Account "+ fromAccount.getId() + " of "+ fromAccount.getOwner()+ " does not have enough balance";
            loggingService.saveLog(fromAccId,toAccId,amount, BankErrorCode.BALANCE_NOT_ENOUGH, detail);
            throw new BankException(BankErrorCode.BALANCE_NOT_ENOUGH, "Not enought balance", detail);
        }
        try {
            fromAccount.setBalance(fromAccount.getBalance()-amount);
            toAccount.setBalance(toAccount.getBalance()+amount);
            fromAccount = accountRepo.save(fromAccount);
            toAccount = accountRepo.save(toAccount);
        }catch (Exception e){
            loggingService.saveLog(fromAccId,toAccId,amount,BankErrorCode.DATABASE_ERROR,e.getMessage());
            return new TransferResult(BankErrorCode.DATABASE_ERROR,e.getMessage());
        }

        transactLogService.saveTransactLog(amount,fromAccount,toAccount);
        loggingService.saveLog(fromAccId,toAccId, amount, BankErrorCode.SUCCESS,"Success");
        return new TransferResult(BankErrorCode.SUCCESS,"Transfer success");
    }
}
