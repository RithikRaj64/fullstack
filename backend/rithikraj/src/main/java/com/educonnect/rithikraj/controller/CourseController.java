package com.educonnect.rithikraj.controller;

import static com.educonnect.rithikraj.utils.Access.COURSE_CREATE;
import static com.educonnect.rithikraj.utils.Access.COURSE_DELETE;
import static com.educonnect.rithikraj.utils.Access.COURSE_READ;
import static com.educonnect.rithikraj.utils.MyConstant.ADD;
import static com.educonnect.rithikraj.utils.MyConstant.GET;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonnect.rithikraj.dto.request.CourseRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.service.CourseService;
import com.educonnect.rithikraj.utils.MyConstant;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(MyConstant.COURSE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT', 'INSTITUTE')")
public class CourseController {
    
    private final CourseService courseService;

    @GetMapping(GET)
    @PreAuthorize(COURSE_READ)
    public ResponseEntity<?> getAllCourses() {
        
        try {
            var response = courseService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping(GET + "/{id}")
    @PreAuthorize(COURSE_READ)
    public ResponseEntity<?> getCourseById(@PathVariable String id) {

        try {
            var response = courseService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }
        
    }

    @PostMapping(ADD)
    @PreAuthorize(COURSE_CREATE)
    public ResponseEntity<?> createCourse(@RequestBody CourseRequest request) {

        try {
            var response = courseService.createCourse(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @DeleteMapping(MyConstant.DELETE + "/{id}")
    @PreAuthorize(COURSE_DELETE)
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {

        try {
            var response = courseService.deleteCourse(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder().message(e.getMessage()).build(), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
