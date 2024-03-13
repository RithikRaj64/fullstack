package com.educonnect.rithikraj.controller;

import static com.educonnect.rithikraj.utils.Access.TRANSACTION_CREATE;
import static com.educonnect.rithikraj.utils.Access.TRANSACTION_READ;
import static com.educonnect.rithikraj.utils.MyConstant.ADD;
import static com.educonnect.rithikraj.utils.MyConstant.GET;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.request.TransactionRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.TransactioinService;
import com.educonnect.rithikraj.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.TRANSACTION)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT', 'INSTITUTE')")
public class TransactionController {
    
    private final TransactioinService transactioinService;

    @GetMapping(GET)
    @PreAuthorize(TRANSACTION_READ)
    public ResponseEntity<?> getAllApplications() {

        try {
            var response = transactioinService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping(ADD)
    @PreAuthorize(TRANSACTION_CREATE)
    public ResponseEntity<?> createApplication(@RequestBody TransactionRequest request) {

        try {
            var response = transactioinService.addTransaction(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
        
    }
}
