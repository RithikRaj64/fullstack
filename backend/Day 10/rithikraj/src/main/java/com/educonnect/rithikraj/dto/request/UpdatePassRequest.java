package com.educonnect.rithikraj.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePassRequest {
    private String email;
    private String oldPassword;
    private String newPassword;
}
