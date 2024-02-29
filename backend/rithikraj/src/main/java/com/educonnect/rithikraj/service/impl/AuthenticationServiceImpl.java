package com.educonnect.rithikraj.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.LoginRequest;
import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.response.LoginResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.enumerated.Role;
import com.educonnect.rithikraj.model.Token;
import com.educonnect.rithikraj.model.User;
import com.educonnect.rithikraj.repository.TokenRepository;
import com.educonnect.rithikraj.repository.UserRepository;
import com.educonnect.rithikraj.service.AuthenticationService;
import com.educonnect.rithikraj.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    @SuppressWarnings("null")
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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                                    .orElseThrow(() -> new UsernameNotFoundException("User not found with the mail " + request.getEmail()));

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().toString());

        var accessToken = jwtUtil.generateToken(claims, user);

        revokeAllUserTokens(user);
        saveUserToken(accessToken, user);

        return LoginResponse.builder()
                            .message("User logged in successfully")
                            .accessToken(accessToken)
                            .build();
    }

    private void saveUserToken(String accessToken, User user) {
        var token = Token.builder()
                            .token(accessToken)
                            .user(user)
                            .expired(false)
                            .revoked(false)
                            .build();

        tokenRepository.save(token);

        throw new UnsupportedOperationException("Unimplemented method 'saveUserToken'");
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllByUser_IdAndExpiredIsFalseAndRevokedIsFalse(user.getId());

        if(validUserTokens.isEmpty()) return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenRepository.saveAll(validUserTokens);
    }
    
}
