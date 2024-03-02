package com.educonnect.rithikraj.service;

public interface StudentService {

    Object getAll();

    Object getById(String id);

    Object deleteById(String id);

    Object updateDetails(String id);
    
}
