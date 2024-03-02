package com.educonnect.rithikraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnect.rithikraj.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    
}
