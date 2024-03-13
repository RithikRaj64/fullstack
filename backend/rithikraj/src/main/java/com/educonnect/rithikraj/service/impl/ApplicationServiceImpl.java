package com.educonnect.rithikraj.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.ApplicationRequest;
import com.educonnect.rithikraj.dto.response.ApplicationResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.exception.NotFoundException;
import com.educonnect.rithikraj.model.Application;
import com.educonnect.rithikraj.repository.ApplicationRepository;
import com.educonnect.rithikraj.repository.CourseRepository;
import com.educonnect.rithikraj.repository.StudentRepository;
import com.educonnect.rithikraj.service.ApplicationService;
import com.educonnect.rithikraj.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @Override
    public List<ApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();

        return applications.stream()
                        .map(application -> ApplicationResponse.builder()
                                .id(application.getId())
                                .studentId(application.getStudent().getId())
                                .studentName(application.getStudent().getUser().getName())
                                .courseId(application.getCourse().getId())                                
                                .courseName(application.getCourse().getCourseName())
                                .status(application.getStatus())
                                .build())
                                .collect(Collectors.toList());
    }

    @Override
    public ApplicationResponse getById(String id) throws NotFoundException {
        Optional<Application> isApplication = applicationRepository.findById(id);

        if(isApplication.isEmpty()) {
            throw new NotFoundException("Application not found with the id : " + id);
        }

        return ApplicationResponse.builder()
                                    .id(isApplication.get().getId())
                                    .studentId(isApplication.get().getStudent().getId())
                                    .studentName(isApplication.get().getStudent().getUser().getName())
                                    .courseId(isApplication.get().getCourse().getId())                                
                                    .courseName(isApplication.get().getCourse().getCourseName())
                                    .status(isApplication.get().getStatus())
                                    .build();
    }

    @Override
    public MessageResponse addApplication(ApplicationRequest request) {
        // Optional<Application> isAppliction = applicationRepository.;
        var application = Application.builder()
                            .student(studentRepository.findById(request.getStudentId()).orElse(null))
                            .course(courseRepository.findById((request.getCourseId())).orElse(null))
                            .build();

        courseService.decreaseAvailableSeatsById(request.getCourseId());

        applicationRepository.save(application);

        return MessageResponse.builder().message("Application posted successfully").build();
    }

    @Override
    public MessageResponse acceptApplication(String id) {
        Application application = applicationRepository.findById(id).orElse(null);

        courseService.increaseAcceptedStudentsById(application.getCourse().getId());

        application.setStatus("Accepted");
        applicationRepository.save(application);

        return MessageResponse.builder().message("Application with id " + id + " has been accepted").build();
    }

    @Override
    public MessageResponse rejectApplicaion(String id) {
        Application application = applicationRepository.findById(id).orElse(null);

        courseService.increaseAvailableSeatsById(application.getCourse().getId());

        application.setStatus("Rejected");
        applicationRepository.save(application);

        return MessageResponse.builder().message("Application with id " + id + " has been rejected").build();
    }
   
    @Override
    public MessageResponse paid(String id) {
        Application application = applicationRepository.findById(id).orElse(null);

        courseService.increaseAvailableSeatsById(application.getCourse().getId());

        application.setStatus("Course Fee Paid");
        applicationRepository.save(application);

        return MessageResponse.builder().message("Application with id " + id + " has been rejected").build();
    }
}
