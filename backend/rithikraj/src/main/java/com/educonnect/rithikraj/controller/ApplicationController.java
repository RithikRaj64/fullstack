package com.educonnect.rithikraj.controller;

import static com.educonnect.rithikraj.utils.Access.APPLICATION_CREATE;
import static com.educonnect.rithikraj.utils.Access.APPLICATION_READ;
import static com.educonnect.rithikraj.utils.Access.APPLICATION_UPDATE;
import static com.educonnect.rithikraj.utils.MyConstant.ACCEPT;
import static com.educonnect.rithikraj.utils.MyConstant.ADD;
import static com.educonnect.rithikraj.utils.MyConstant.GET;
import static com.educonnect.rithikraj.utils.MyConstant.REJECT;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.request.ApplicationRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.ApplicationService;
import com.educonnect.rithikraj.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.APPLICATION)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT', 'INSTITUTE')")
public class ApplicationController {
    
    private final ApplicationService applicationService;

    @GetMapping(GET)
    @PreAuthorize(APPLICATION_READ)
    public ResponseEntity<?> getAllApplications() {

        try {
            var response = applicationService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping(GET + "/{id}")
    @PreAuthorize(APPLICATION_READ)
    public ResponseEntity<?> getApplicationByID(@PathVariable String id) {
        
        try {
            var response = applicationService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping(ADD)
    @PreAuthorize(APPLICATION_CREATE)
    public ResponseEntity<?> createApplication(@RequestBody ApplicationRequest request) {

        try {
            var response = applicationService.addApplication(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
    @PatchMapping(ACCEPT + "/{id}")
    @PreAuthorize(APPLICATION_UPDATE)
    public ResponseEntity<?> acceptApplication(@PathVariable String id) {
        
        try {
            var response = applicationService.acceptApplication(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    
    @PatchMapping(REJECT + "/{id}")
    @PreAuthorize(APPLICATION_UPDATE)
    public ResponseEntity<?> rejectApplication(@PathVariable String id) {
        
        try {
            var response = applicationService.rejectApplicaion(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PatchMapping("/paid/{id}")
    @PreAuthorize(APPLICATION_UPDATE)
    public ResponseEntity<?> paid(@PathVariable String id) {
        
        try {
            var response = applicationService.paid(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
