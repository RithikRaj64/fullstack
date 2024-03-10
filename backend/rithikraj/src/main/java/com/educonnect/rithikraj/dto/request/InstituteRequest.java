package com.educonnect.rithikraj.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstituteRequest {
    private String instituteName;
    private String location;
    private String email;
    private String mobile;
    private String website;
    private String about;
}
