package com.educonnect.rithikraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnect.rithikraj.model.Token;

public interface TokenRepository extends JpaRepository<Token, String> {

}
