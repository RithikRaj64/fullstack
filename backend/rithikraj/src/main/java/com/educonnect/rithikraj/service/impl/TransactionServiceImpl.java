package com.educonnect.rithikraj.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.TransactionRequest;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.dto.response.TransactionResponse;
import com.educonnect.rithikraj.model.Transaction;
import com.educonnect.rithikraj.repository.ApplicationRepository;
import com.educonnect.rithikraj.repository.TransactionRepository;
import com.educonnect.rithikraj.service.TransactioinService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class TransactionServiceImpl implements TransactioinService {

    private final TransactionRepository transactionRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public List<TransactionResponse> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();

        return transactions.stream()
                        .map(transaction -> TransactionResponse.builder()
                                    .id(transaction.getId())
                                    .amount(transaction.getAmount())
                                    .date(transaction.getDate())
                                    .transactionType(transaction.getTransactionType())
                                    .applicationId(transaction.getApplication().getId())
                                    .build())
                                    .collect(Collectors.toList());
    }

    @Override
    public MessageResponse addTransaction(TransactionRequest request) {
        var transaction = Transaction.builder()
                                .amount(request.getAmount())
                                .date(new Date())
                                .transactionType(request.getTransactionType())
                                .application(applicationRepository.findById(request.getApplicationId()).orElse(null))
                                .build();

        transactionRepository.save(transaction);
        
        return MessageResponse.builder().message("Transaction done").build();
    }
    
}
