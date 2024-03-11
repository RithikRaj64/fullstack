package com.educonnect.rithikraj.service.impl;

import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.UserResponse;
import com.educonnect.rithikraj.repository.UserRepository;
import com.educonnect.rithikraj.service.UserServ;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class UserServImpl implements UserServ {
    
    private final UserRepository userRepository;

    @Override
    public MessageResponse getIns(String id) {
        var user = userRepository.findById(id).orElse(null);
        return MessageResponse.builder().message(user.getInstitute().getId()).build();
    }
    
    @Override
    public MessageResponse getStu(String id) {
        var user = userRepository.findById(id).orElse(null);
        return MessageResponse.builder().message(user.getStudent().getId()).build();
    }

    @Override
    public UserResponse getById(String id) {
        var user = userRepository.findById(id).orElse(null);

        return UserResponse.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .mobile(user.getMobile())
                        .password("***")
                        .build();
    }

}
