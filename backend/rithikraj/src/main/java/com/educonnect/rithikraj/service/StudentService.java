package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.StudentResponse;
import com.educonnect.rithikraj.exception.StudentNotFoundException;

public interface StudentService {

    List<StudentResponse> getAll();

    StudentResponse getByEmail(String email) throws StudentNotFoundException;

    MessageResponse deleteByEmail(String email);

    MessageResponse updateDetails(String id);
    
}
