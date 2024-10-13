package com.enes.expensetracker.service.impl;

import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.dto.request.transaction.TransactionRequest;
import com.enes.expensetracker.model.dto.response.transaction.TransactionResponse;
import com.enes.expensetracker.repository.TransactionRepository;
import com.enes.expensetracker.service.TransactionService;
import com.enes.expensetracker.service.business.TransactionBusinessRules;
import com.enes.expensetracker.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionBusinessRules transactionBusinessRules;


    @Override
    public List<TransactionResponse> findAll() {
        return  transactionRepository.findAll()
                .stream()
                .map(TransactionMapper.INSTANCE::fromTransaction)
                .collect(Collectors.toList());
    }
    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        transactionBusinessRules.isUserIdExist(transactionRequest.userid());
        Transaction transaction = transactionBusinessRules.prepareTransactionForCreate(transactionRequest);
        transactionRepository.save(transaction);
        return TransactionMapper.INSTANCE.fromTransaction(transaction);
    }

    @Override
    public void deleteTransactionById(Long transactionId) {
        var transaction = transactionBusinessRules.getTransactionIfExist(transactionId);
        transactionRepository.delete(transaction);
    }


}
