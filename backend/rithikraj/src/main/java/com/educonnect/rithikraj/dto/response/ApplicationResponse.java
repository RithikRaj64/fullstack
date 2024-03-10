package com.educonnect.rithikraj.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponse {
    private String id;
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private String status;
}
