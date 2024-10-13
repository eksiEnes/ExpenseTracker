package com.enes.expensetracker.service.mapper;


import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.User;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionRequest;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

    public Transaction toTransaction(TransactionRequest request) {
        if(request == null) return null;
        User user = new User();
        user.setId(request.userid());
        return Transaction.builder()
                .description(request.Description())
                .amount(request.Amount())
                .user(user)
                .build();
    }

    public TransactionResponse fromTransaction(Transaction transaction) {
        return new TransactionResponse(
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getUser().getEmail()
        );
    }
}
