// package com.educonnect.rithikraj.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// // import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.educonnect.rithikraj.dto.request.RegisterRequest;
// import com.educonnect.rithikraj.dto.request.UpdatePassRequest;
// import com.educonnect.rithikraj.dto.response.MessageResponse;
// import com.educonnect.rithikraj.dto.response.UserResponse;
// import com.educonnect.rithikraj.exception.UserNotFoundException;
// import com.educonnect.rithikraj.service.UserService;
// import com.educonnect.rithikraj.utils.MyConstant;

// import lombok.RequiredArgsConstructor;

// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// @RestController
// @RequestMapping(MyConstant.USER)
// @RequiredArgsConstructor
// // @PreAuthorize("hasRole('ADMIN')")
// // @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
// public class NotUserController {

//     private final UserService userService;

//     @PostMapping(MyConstant.REGISTER)
//     public ResponseEntity<?> signUpUser(@RequestBody RegisterRequest request) {
//         MessageResponse response = new MessageResponse();

//         try {
//             response = userService.register(request);
//             return new ResponseEntity<>(response, HttpStatus.CREATED);
//         } catch (Exception e) {
//             return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
//         }
//     }

//     @GetMapping(MyConstant.GET)
//     // @PreAuthorize("hasAuthority('user:read')")
//     public ResponseEntity<?> getAllUsers() {
        
//         try {
//             var response = userService.getAll();
//             return new ResponseEntity<>(response, HttpStatus.OK);
//         } catch (Exception e) {
//             return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
//         }
//     }
    
//     @GetMapping(MyConstant.GET + "/{id}")
//     public ResponseEntity<?> getUserByID(@PathVariable String id) {
//         UserResponse response = new UserResponse();
    
//         try {
//             response = userService.getById(id);
//             return new ResponseEntity<>(response, HttpStatus.OK);
//         } catch (UserNotFoundException exception) {
//             var responseMessage = MessageResponse.builder().message(exception.getMessage()).build();
//             return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
//         } catch (Exception e) {
//             return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
//         }
//     }
    
//     @DeleteMapping(MyConstant.DELETE + "/{id}")
//     public ResponseEntity<?> deleteUserByID(@PathVariable String id) {
//         MessageResponse response = new MessageResponse();   

//         try {
//             response = userService.delete(id);
//             return new ResponseEntity<>(response, HttpStatus.OK);
//         } catch (Exception e) {
//             return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
//         }

//     }

//     @PatchMapping(MyConstant.UPDATE)
//     public ResponseEntity<?> updateUserPassword(@RequestBody UpdatePassRequest request) {
//         MessageResponse response = new MessageResponse();

//         try {
//             response = userService.updatePassword(request);
//             return new ResponseEntity<>(response, HttpStatus.OK);
//         } catch (Exception e) {
//             return new ResponseEntity<>(new MessageResponse(), HttpStatus.EXPECTATION_FAILED);
//         }
//     }
    
// }