package com.educonnect.rithikraj.controller;

import static com.educonnect.rithikraj.utils.MyConstant.AUTH;
import static com.educonnect.rithikraj.utils.MyConstant.REGISTER;
import static com.educonnect.rithikraj.utils.MyConstant.SIGNIN;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.request.LoginRequest;
import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.response.LoginResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(REGISTER)
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        MessageResponse response = new MessageResponse();

        try {
            response = authenticationService.register(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(response.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(SIGNIN)
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        LoginResponse response = new LoginResponse();

        try {
            response = authenticationService.login(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
