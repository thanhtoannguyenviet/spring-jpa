package com.example.springjpa.model;

import com.example.springjpa.exception.BankErrorCode;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class AllLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long fromId;
    private long toId;
    private long amount;
    private BankErrorCode resultCode;
    private String detail;
    private Date createdOn;
    public AllLog (long fromID, long toID, Long amount,
                   BankErrorCode resultCode, String detail){
        this.fromId = fromID;
        this.toId = toID;
        this.amount = amount;
        this.resultCode = resultCode;
        this.detail = detail;
        this.createdOn = new Date();
    }
}
