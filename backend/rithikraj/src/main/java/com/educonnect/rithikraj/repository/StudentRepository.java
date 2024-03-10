package com.educonnect.rithikraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnect.rithikraj.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
