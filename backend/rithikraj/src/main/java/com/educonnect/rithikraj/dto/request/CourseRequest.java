package com.educonnect.rithikraj.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private String degreeLevel;
    private int duration;
    private int noOfSemesters;
    private String description;
    private float fees;
    private int totalSeats;
    private int availableSeats;
    private String instituteId;
}
