package com.educonnect.rithikraj.service;

import com.educonnect.rithikraj.dto.request.LoginRequest;
import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.response.LoginResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;

public interface AuthenticationService {

    MessageResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
    
}
