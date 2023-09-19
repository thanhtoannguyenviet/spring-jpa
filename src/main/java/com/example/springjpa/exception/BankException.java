package com.example.springjpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankException extends RuntimeException{
    private BankErrorCode status;
    private String message;
    private String detail;

}
