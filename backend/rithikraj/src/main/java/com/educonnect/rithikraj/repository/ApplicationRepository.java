package com.educonnect.rithikraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnect.rithikraj.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, String> {
    
}
