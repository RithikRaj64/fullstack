package com.educonnect.rithikraj.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.StudentRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.StudentResponse;
import com.educonnect.rithikraj.exception.StudentNotFoundException;
import com.educonnect.rithikraj.model.Student;
import com.educonnect.rithikraj.repository.StudentRepository;
import com.educonnect.rithikraj.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> getAll() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                        .map(student -> StudentResponse.builder()
                            .id(student.getId())
                            .fatherName(student.getFatherName())
                            .motherName(student.getMotherName())
                            .dob(student.getDob())
                            .gender(student.getGender())
                            .emisNo(student.getEmisNo())
                            .aadharNo(student.getAadharNo())
                            .nationality(student.getNationality())
                            .tenthBoard(student.getTenthBoard())
                            .twelthBoard(student.getTwelthBoard())
                            .tenthPercentage(student.getTenthPercentage())
                            .twelthPercentage(student.getTwelthPercentage())
                            .build())
                            .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getById(String id) throws StudentNotFoundException {
        Optional<Student> isStudent = studentRepository.findById(id);

        if(isStudent.isEmpty()) {
            throw new StudentNotFoundException("Student not found with the mail id : " + id);
        }

        return StudentResponse.builder()
                                .id(isStudent.get().getId())
                                .fatherName(isStudent.get().getFatherName())
                                .motherName(isStudent.get().getMotherName())
                                .dob(isStudent.get().getDob())
                                .gender(isStudent.get().getGender())
                                .emisNo(isStudent.get().getEmisNo())
                                .aadharNo(isStudent.get().getAadharNo())
                                .nationality(isStudent.get().getNationality())
                                .tenthBoard(isStudent.get().getTenthBoard())
                                .twelthBoard(isStudent.get().getTwelthBoard())
                                .tenthPercentage(isStudent.get().getTenthPercentage())
                                .twelthPercentage(isStudent.get().getTwelthPercentage())
                                .build();
    }

    @Override
    public MessageResponse deleteById(String id) {
        Optional<Student> isStudent = studentRepository.findById(id);

        if(isStudent.isEmpty()) {
            return MessageResponse.builder()
                                    .message("Student not found with the mail id : " + id)
                                    .build();
        }

        studentRepository.delete(isStudent.get());

        return MessageResponse.builder()
                                .message("Student deleted successfully")
                                .build();
    }

    @Override
    public MessageResponse updateDetails(String id, StudentRequest request) {
        Student student = studentRepository.findById(id).orElse(null);

        System.out.println(request.toString());

        student = setStudentDetails(student, request);
        if(done(student)) student.setCompleted(true);
        
        studentRepository.save(student);

        return MessageResponse.builder().message("Student details updated successfully").build();
    }

    private boolean done(Student student) {
        Field[] fields = student.getClass().getDeclaredFields();
        
        for(Field field : fields) {
            field.setAccessible(true);
            try {
                if(field.get(student) == null) return false;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    private Student setStudentDetails(Student student, StudentRequest request) {
        if(student.getFatherName() == null) student.setFatherName(request.getFatherName());
        if(student.getMotherName() == null) student.setMotherName(request.getMotherName());
        if(student.getDob() == null) student.setDob(request.getDob());
        if(student.getGender() == null) student.setGender(request.getGender());
        if(student.getEmisNo() == null) student.setEmisNo(request.getEmisNo());
        if(student.getAadharNo() == null) student.setAadharNo(request.getAadharNo());
        if(student.getNationality() == null) student.setNationality(request.getNationality());
        if(student.getTenthBoard() == null) student.setTenthBoard(request.getTenthBoard());
        if(student.getTenthPercentage() == 0) student.setTenthPercentage(request.getTenthPercentage());
        if(student.getTwelthBoard() == null) student.setTwelthBoard(request.getTwelthBoard());
        if(student.getTwelthPercentage() == 0) student.setTwelthPercentage(request.getTwelthPercentage());

        return student;
    }

}
