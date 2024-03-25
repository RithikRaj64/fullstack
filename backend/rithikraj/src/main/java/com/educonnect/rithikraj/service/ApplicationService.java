package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.request.ApplicationRequest;
import com.educonnect.rithikraj.dto.response.ApplicationResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.exception.NotFoundException;

public interface ApplicationService {

    List<ApplicationResponse> getAll();

    ApplicationResponse getById(String id) throws NotFoundException;

    MessageResponse addApplication(ApplicationRequest request);
    
    MessageResponse acceptApplication(String id);

    MessageResponse rejectApplicaion(String id);

    MessageResponse paid(String id);

    List<ApplicationResponse> getByStudId(String id);

    List<ApplicationResponse> getByInstId(String id);
}
