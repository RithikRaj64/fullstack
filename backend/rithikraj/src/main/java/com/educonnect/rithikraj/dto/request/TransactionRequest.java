package com.educonnect.rithikraj.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private float amount;
    private String transactionType;
    private String applicationId;
    // private boolean transactionStatus;
}
