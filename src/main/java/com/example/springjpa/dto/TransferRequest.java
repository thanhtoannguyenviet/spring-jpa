package com.example.springjpa.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private long accountFrom;
    private long accountTo;
    private long amount;

}
