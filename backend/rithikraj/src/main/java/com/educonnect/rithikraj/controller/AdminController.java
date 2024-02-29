package com.educonnect.rithikraj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.utils.MyConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(MyConstant.ADMIN)
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @GetMapping()
    public ResponseEntity<?> getMethodName(@RequestParam String param) {
        return new ResponseEntity<>("Admin:GET", HttpStatus.OK);
    }

}
