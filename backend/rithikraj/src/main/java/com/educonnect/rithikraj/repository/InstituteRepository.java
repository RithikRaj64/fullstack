package com.educonnect.rithikraj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnect.rithikraj.model.Institute;

public interface InstituteRepository extends JpaRepository<Institute, String> {
    Optional<Institute> findByEmail(String email);
}
