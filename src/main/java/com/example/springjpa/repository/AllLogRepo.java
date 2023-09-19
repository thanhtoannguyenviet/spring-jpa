package com.example.springjpa.repository;

import com.example.springjpa.model.AllLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllLogRepo extends JpaRepository<AllLog,Long> {
}
