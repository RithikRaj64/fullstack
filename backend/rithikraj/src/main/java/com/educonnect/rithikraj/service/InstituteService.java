package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.exception.NotFoundException;
import com.educonnect.rithikraj.model.Institute;

public interface InstituteService {

    List<Institute> getAll();

    Institute getById(String id) throws NotFoundException;

    MessageResponse deleteById(String id);

    MessageResponse updateDetails(String id);
    
}
