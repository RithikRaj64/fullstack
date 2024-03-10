package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.request.StudentRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.StudentResponse;
import com.educonnect.rithikraj.exception.StudentNotFoundException;

public interface StudentService {

    List<StudentResponse> getAll();

    StudentResponse getById(String id) throws StudentNotFoundException;

    MessageResponse deleteById(String id);

    MessageResponse updateDetails(String id, StudentRequest request);
    
}
