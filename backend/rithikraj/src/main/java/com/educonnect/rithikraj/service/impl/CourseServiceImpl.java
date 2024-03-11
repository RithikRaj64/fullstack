package com.educonnect.rithikraj.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.CourseRequest;
import com.educonnect.rithikraj.dto.response.CourseResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.exception.NotFoundException;
import com.educonnect.rithikraj.model.Course;
import com.educonnect.rithikraj.model.Institute;
import com.educonnect.rithikraj.repository.CourseRepository;
import com.educonnect.rithikraj.repository.InstituteRepository;
import com.educonnect.rithikraj.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstituteRepository instituteRepository;

    @Override
    public List<CourseResponse> getAll() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(course -> CourseResponse.builder()
                                .id(course.getId())
                                .courseName(course.getCourseName())
                                .instituteName(course.getInstituteName())
                                .degreeLevel(course.getDegreeLevel())
                                .duration(course.getDuration())
                                .noOfSemesters(course.getNoOfSemesters())
                                .description(course.getDescription())
                                .fees(course.getFees())
                                .totalSeats(course.getTotalSeats())
                                .availableSeats(course.getAvailableSeats())
                                .acceptedStudents(course.getAcceptedStudents())
                                .build())
                                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getById(String id) throws NotFoundException {
        Optional<Course> isCourse = courseRepository.findById(id);

        if(isCourse.isEmpty()) {
            throw new NotFoundException("Course not found with the id : " + id);
        }

        return CourseResponse.builder()
                        .id(isCourse.get().getId())
                        .courseName(isCourse.get().getCourseName())
                        .instituteName(isCourse.get().getInstituteName())
                        .degreeLevel(isCourse.get().getDegreeLevel())
                        .duration(isCourse.get().getDuration())
                        .noOfSemesters(isCourse.get().getNoOfSemesters())
                        .description(isCourse.get().getDescription())
                        .fees(isCourse.get().getFees())
                        .totalSeats(isCourse.get().getTotalSeats())
                        .availableSeats(isCourse.get().getAvailableSeats())
                        .acceptedStudents(isCourse.get().getAcceptedStudents())
                        .build();
    }

    @Override
    public MessageResponse decreaseAvailableSeatsById(String id) {
        Course course = courseRepository.findById(id).orElse(null);

        course.setAvailableSeats(course.getAvailableSeats() - 1);
        courseRepository.save(course);

        return MessageResponse.builder().message("Available seats decreased by 1 for the course with id " + id).build();
    }

    @Override
    public MessageResponse increaseAvailableSeatsById(String id) {
        Course course = courseRepository.findById(id).orElse(null);

        course.setAvailableSeats(course.getAvailableSeats() + 1);
        courseRepository.save(course);

        return MessageResponse.builder().message("Available seats increased by 1 for the course with id " + id).build();
    }

    @Override
    public MessageResponse increaseAcceptedStudentsById(String id) {
        Course course = courseRepository.findById(id).orElse(null);

        course.setAcceptedStudents(course.getAcceptedStudents() + 1);
        courseRepository.save(course);

        return MessageResponse.builder().message("Accepted students decreased by 1 for the course with id " + id).build();
    }

    @Override
    public MessageResponse createCourse(CourseRequest request) {
        Institute institute = instituteRepository.findById(request.getInstituteId()).orElse(null);
        
        var course = Course.builder()
                            .courseName(request.getCourseName())
                            .instituteName(institute.getInstituteName())
                            .institute(institute)
                            .degreeLevel(request.getDegreeLevel())
                            .duration(request.getDuration())
                            .noOfSemesters(request.getNoOfSemesters())
                            .description(request.getDescription())
                            .fees(request.getFees())
                            .totalSeats(request.getTotalSeats())
                            .availableSeats(request.getAvailableSeats())
                            .build();

        courseRepository.save(course);

        return MessageResponse.builder().message("Course created successfully").build();
    }

    @Override
    public MessageResponse deleteCourse(String id) {
        courseRepository.deleteById(id);

        return MessageResponse.builder().message("Course deleted successfully").build();
    }
    
}
