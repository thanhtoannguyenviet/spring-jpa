package com.example.springjpa.repository;

import com.example.springjpa.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
    @Query("SELECT a FROM Account  a WHERE a.owner LIKE %:name%")
    Page<Account> findAllByOwner(String name, Pageable pageable);
}
