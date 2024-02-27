package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.UserResponse;
import com.educonnect.rithikraj.utils.UserNotFoundException;

public interface UserService {

    MessageResponse register(RegisterRequest request);

    List<UserResponse> getAll();

    UserResponse getById(String id) throws UserNotFoundException;

    MessageResponse delete(String id);

    MessageResponse updatePassword(String id, String password);

}
