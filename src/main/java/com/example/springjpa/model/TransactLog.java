package com.example.springjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account accountFrom;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account accountTo;

    private long amount;
    private Date createdOn;

    public TransactLog(Account accountFrom, Account accountTo, long amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.createdOn = new Date();
    }
}
