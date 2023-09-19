package com.example.springjpa.dto;

import com.example.springjpa.exception.BankErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferResult {
    private BankErrorCode resultCode;
    private String message;
    private Date transferDate;

    public TransferResult(BankErrorCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
        this.transferDate = new Date();
    }
}
