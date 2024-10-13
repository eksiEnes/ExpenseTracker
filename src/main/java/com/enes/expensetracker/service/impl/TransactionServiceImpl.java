package com.enes.expensetracker.service.impl;

import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionRequest;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionResponse;
import com.enes.expensetracker.repository.TransactionRepository;
import com.enes.expensetracker.service.TransactionService;
import com.enes.expensetracker.service.UserService;
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
    private final TransactionMapper transactionMapper;


    @Override
    public List<TransactionResponse> findAll() {
        return  transactionRepository.findAll()
                .stream()
                .map(transactionMapper::fromTransaction)
                .collect(Collectors.toList());
    }
    // TODO BU FONKSİYON KONTROL EDİLCEK TRANSACTION OLUŞTURURKEN USER ID KISMI SIKINTILI MAP STRUCT KULLANMAK ZORUNDA KALICAM GIBI
    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        transactionBusinessRules.validateTransactionRequest(transactionRequest);
        Transaction transaction = transactionBusinessRules.prepareTransactionForCreate(transactionRequest);
        transactionRepository.save(transaction);
        return transactionMapper.fromTransaction(transaction);
    }

    @Override
    public void deleteTransactionById(Long transactionId) {
        var transaction = transactionBusinessRules.getTransactionIfExist(transactionId);
        transactionRepository.delete(transaction);
    }


}
