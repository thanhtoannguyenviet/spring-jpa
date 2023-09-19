package com.example.springjpa.repository;

import com.example.springjpa.model.TransactLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactLogRepo extends JpaRepository<TransactLog, Long> {
}
