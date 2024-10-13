package com.enes.expensetracker.service.business;

import com.enes.expensetracker.exception.type.BusinessException;
import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.User;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionRequest;
import com.enes.expensetracker.repository.TransactionRepository;
import com.enes.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionBusinessRules {

    private final TransactionRepository transactionRepository;
    private final UserService userService;

    // TransactionRequest üzerindeki iş kuralları doğrulama
    public void validateTransactionRequest(TransactionRequest request) {
        // Örnek: Transaction açıklaması boş olamaz vb.
        if (request.Amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("Transaction amount must be positive.");
        }
    }

    // Transaction oluştururken gerekli iş mantığı
    public Transaction prepareTransactionForCreate(TransactionRequest request) {
        // Kullanıcıyı e-posta ile bul ve transaction'a ata
          var user = userService.findById(request.userid());

        return Transaction.builder()
                .description(request.Description())
                .amount(request.Amount())
                //.user()
                .build();
    }

    // Transaction mevcut mu kontrolü
    public Transaction getTransactionIfExist(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new BusinessException("Transaction not found with id: " + transactionId));
    }
}
