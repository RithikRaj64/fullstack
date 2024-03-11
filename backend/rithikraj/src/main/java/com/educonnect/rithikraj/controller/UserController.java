package com.educonnect.rithikraj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.UserServ;
import com.educonnect.rithikraj.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.USER)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT', 'INSTITUTE')")
public class UserController {
    
    private final UserServ userServ;

    @GetMapping("/getIns/{id}")
    public ResponseEntity<?> getInstituteId(@PathVariable String id) {

        try {
            var response = userServ.getIns(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/getStu/{id}")
    public ResponseEntity<?> getStudentId(@PathVariable String id) {

        try {
            var response = userServ.getStu(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        
        try {
            var response = userServ.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
