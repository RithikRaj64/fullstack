package com.educonnect.rithikraj.controller;

import static com.educonnect.rithikraj.utils.Access.INSTITUTE_READ;
import static com.educonnect.rithikraj.utils.Access.INSTITUTE_DELETE;
import static com.educonnect.rithikraj.utils.Access.INSTITUTE_UPDATE;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.request.InstituteRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.InstituteService;
import com.educonnect.rithikraj.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.INSTITUTE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT', 'INSTITUTE')")
public class InstituteController {

    private final InstituteService instituteService;
    
    @GetMapping(GET)
    @PreAuthorize(INSTITUTE_READ)
    public ResponseEntity<?> getAllUsers() {
        
        try {
            var response = instituteService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @GetMapping(GET + "/{id}")
    @PreAuthorize(INSTITUTE_READ)
    public ResponseEntity<?> getUserByID(@PathVariable String id) {
        
        try {
            var response = instituteService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(DELETE + "/{id}")
    @PreAuthorize(INSTITUTE_DELETE)
    public ResponseEntity<?> deleteUserByID(@PathVariable String id) {
        
        try {
            var response = instituteService.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PatchMapping(UPDATE_DETAILS + "/{id}")
    @PreAuthorize(INSTITUTE_UPDATE)
    public ResponseEntity<?> updateDetails(@PathVariable String id, @RequestBody InstituteRequest request) {
        
        try {
            var response = instituteService.updateDetails(id, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse().builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }
}
