package com.educonnect.rithikraj.service;

import java.util.List;

import com.educonnect.rithikraj.dto.request.TransactionRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.TransactionResponse;

public interface TransactioinService {

    List<TransactionResponse> getAll();

    MessageResponse addTransaction(TransactionRequest request);
    
}
