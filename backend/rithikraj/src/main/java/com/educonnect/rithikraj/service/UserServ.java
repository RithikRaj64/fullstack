package com.educonnect.rithikraj.service;

import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.UserResponse;

public interface UserServ {

    MessageResponse getIns(String id);

    MessageResponse getStu(String id);

    UserResponse getById(String id);
    
}
