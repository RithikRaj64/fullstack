package com.educonnect.rithikraj.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String id;
    private String courseName;
    private String instituteName;
    private String degreeLevel;
    private int duration;
    private int noOfSemesters;
    private String description;
    private float fees;
    private int totalSeats;
    private int availableSeats;
    private int acceptedStudents;
}
