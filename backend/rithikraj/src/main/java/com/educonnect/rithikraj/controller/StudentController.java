package com.educonnect.rithikraj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.StudentService;
import com.educonnect.rithikraj.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.STUDENT)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT', 'INSTITUTE')")
public class StudentController {

    private StudentService studentService;
    
    @GetMapping(MyConstant.GET)
    @PreAuthorize("hasAuthority('student:read')")
    public ResponseEntity<?> getAllUsers() {
        
        try {
            var response = studentService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
