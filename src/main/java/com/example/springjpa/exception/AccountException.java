package com.example.springjpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountException extends RuntimeException{
    private BankErrorCode errorCode;
    private String message;
}
