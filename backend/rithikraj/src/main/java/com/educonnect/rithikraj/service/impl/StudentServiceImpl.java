package com.educonnect.rithikraj.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
    public StudentResponse getByEmail(String email) throws StudentNotFoundException {
        Optional<Student> isStudent = studentRepository.findByEmail(email);

        if(isStudent.isEmpty()) {
            throw new StudentNotFoundException("Student not found with the mail id : " + email);
        }

        return StudentResponse.builder()
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
    public MessageResponse deleteByEmail(String email) {
        Optional<Student> isStudent = studentRepository.findByEmail(email);

        if(isStudent.isEmpty()) {
            return MessageResponse.builder()
                                    .message("Student not found with the mail id : " + email)
                                    .build();
        }

        studentRepository.delete(isStudent.get());

        return MessageResponse.builder()
                                .message("Student deleted successfully")
                                .build();
    }

    @Override
    public MessageResponse updateDetails(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDetails'");
    }

}
