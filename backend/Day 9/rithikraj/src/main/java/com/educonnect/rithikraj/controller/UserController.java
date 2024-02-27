package com.educonnect.rithikraj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.dto.request.UpdatePassRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.UserResponse;
import com.educonnect.rithikraj.service.UserService;
import com.educonnect.rithikraj.utils.MyConstant;
import com.educonnect.rithikraj.utils.UserNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(MyConstant.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(MyConstant.REGISTER)
    public ResponseEntity<?> postMethodName(@RequestBody RegisterRequest request) {
        MessageResponse response = new MessageResponse();

        try {
            response = userService.register(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(MyConstant.GET)
    public ResponseEntity<?> getMethodName() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping(MyConstant.GET + "/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable String id) {
        UserResponse response = new UserResponse();
    
        try {
            response = userService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            var responseMessage = MessageResponse.builder().message(exception.getMessage()).build();
            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @DeleteMapping(MyConstant.DELETE + "/{id}")
    public ResponseEntity<?> deleteMethodName(@PathVariable String id) {
        MessageResponse response = new MessageResponse();   

        try {
            response = userService.delete(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PatchMapping(MyConstant.UPDATE_PASSWORD)
    public ResponseEntity<?> patchMethodName(@RequestBody UpdatePassRequest request) {
        MessageResponse response = new MessageResponse();

        try {
            response = userService.updatePassword(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}

// Create request and response dto, models, one CRUD for user table, get all , get all by ID