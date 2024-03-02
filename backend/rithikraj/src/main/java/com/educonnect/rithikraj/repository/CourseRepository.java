package com.educonnect.rithikraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonnect.rithikraj.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
    
}
