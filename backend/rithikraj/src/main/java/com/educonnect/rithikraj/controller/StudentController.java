package com.educonnect.rithikraj.controller;

import static com.educonnect.rithikraj.utils.Access.STUDENT_DELETE;
import static com.educonnect.rithikraj.utils.Access.STUDENT_READ;
import static com.educonnect.rithikraj.utils.Access.STUDENT_UPDATE;
import static com.educonnect.rithikraj.utils.MyConstant.DELETE;
import static com.educonnect.rithikraj.utils.MyConstant.GET;
import static com.educonnect.rithikraj.utils.MyConstant.UPDATE_DETAILS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping(GET)
    @PreAuthorize(STUDENT_READ)
    public ResponseEntity<?> getAllUsers() {
        
        try {
            var response = studentService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @GetMapping(GET + "/{email}")
    @PreAuthorize(STUDENT_READ)
    public ResponseEntity<?> getUserByID(@PathVariable String email) {
        
        try {
            var response = studentService.getByEmail(email);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(DELETE + "/{id}")
    @PreAuthorize(STUDENT_DELETE)
    public ResponseEntity<?> deleteUserByID(@PathVariable String id) {
        
        try {
            var response = studentService.deleteByEmail(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PatchMapping(UPDATE_DETAILS)
    @PreAuthorize(STUDENT_UPDATE)
    public ResponseEntity<?> updateDetails(@PathVariable String id) {
        
        try {
            var response = studentService.updateDetails(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}