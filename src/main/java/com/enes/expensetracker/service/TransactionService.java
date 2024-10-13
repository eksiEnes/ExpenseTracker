package com.enes.expensetracker.service;


import com.enes.expensetracker.model.dto.request.Transaction.TransactionRequest;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface TransactionService {
    List<TransactionResponse> findAll();

    TransactionResponse createTransaction(@Valid TransactionRequest transactionRequest);

    void deleteTransactionById(Long transactionId);
}
