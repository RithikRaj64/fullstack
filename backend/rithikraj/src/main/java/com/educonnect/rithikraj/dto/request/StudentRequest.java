package com.educonnect.rithikraj.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String fatherName;
    private String motherName;
    private Date dob;
    private String gender;
    private String emisNo;
    private String aadharNo;
    private String nationality;
    private String tenthBoard;
    private float tenthPercentage; 
    private String twelthBoard;
    private float twelthPercentage;
}
