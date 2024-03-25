package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.request.CourseRequest;
import com.educonnect.rithikraj.dto.response.CourseResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.exception.NotFoundException;

public interface CourseService {

    List<CourseResponse> getAll();

	CourseResponse getById(String id) throws NotFoundException;

    MessageResponse decreaseAvailableSeatsById(String id);

    MessageResponse increaseAvailableSeatsById(String id);

    MessageResponse increaseAcceptedStudentsById(String id);

    MessageResponse createCourse(CourseRequest request);

    MessageResponse deleteCourse(String id);

    MessageResponse getFee(String id);

    List<CourseResponse> getByInstId(String id);
    
}
