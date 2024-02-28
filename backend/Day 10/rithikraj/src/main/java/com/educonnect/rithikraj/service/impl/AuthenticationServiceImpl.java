package com.educonnect.rithikraj.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.LoginRequest;
import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.response.LoginResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.enumerated.Role;
import com.educonnect.rithikraj.model.User;
import com.educonnect.rithikraj.repository.UserRepository;
import com.educonnect.rithikraj.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MessageResponse register(RegisterRequest request) {
        Optional<User> isUser = userRepository.findByEmail(request.getEmail());

        if(isUser.isPresent()) {
            return MessageResponse.builder()
                                    .message("User already exists with email " + request.getEmail())
                                    .build();
        }

        var user = User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.valueOf(request.getRole()))
                        .mobile(request.getMobile())
                        .build();

        userRepository.save(user);

        return MessageResponse.builder()
                                .message("User registered successfully")
                                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> isUser = userRepository.findByEmail(request.getEmail());
        
        if(isUser.isPresent() && passwordEncoder.matches(request.getPassword(), isUser.get().getPassword())) {
            return LoginResponse.builder()
                                .message("Login successful")
                                .build();
        }

        return null;
    }
    
}
