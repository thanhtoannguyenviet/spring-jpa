package com.example.springjpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table
@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;
    private long balance;
    private AccountState state;

    public Account(String owner, long balance) {
        this.owner = owner;
        this.balance = balance;
    }
}
