package com.enes.expensetracker.service.business;

import com.enes.expensetracker.exception.type.BusinessException;
import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.dto.request.transaction.TransactionRequest;
import com.enes.expensetracker.repository.TransactionRepository;
import com.enes.expensetracker.service.UserService;
import com.enes.expensetracker.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TransactionBusinessRules {

    private final TransactionRepository transactionRepository;
    private final UserService userService; // UserService hâlâ burada, ancak sadece UserResponse alacağız



    public void isUserIdExist(long id){
        if(userService.findById(id) == null){
            throw new BusinessException(String.format("Transaction not found with id: " + id));
        }
    }
    // Transaction oluştururken gerekli iş mantığı
    public Transaction prepareTransactionForCreate(TransactionRequest request) {

        userService.findById(request.userid());
        Transaction transaction = TransactionMapper.INSTANCE.toTransaction(request);
        transactionRepository.save(transaction);
        return transaction;
    }

    // Transaction mevcut mu kontrolü
    public Transaction getTransactionIfExist(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new BusinessException("Transaction not found with id: " + transactionId));
    }
}