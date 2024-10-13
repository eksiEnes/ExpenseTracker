package com.enes.expensetracker.controller;



import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionRequest;
import com.enes.expensetracker.model.dto.request.Transaction.TransactionResponse;
import com.enes.expensetracker.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping
    public ResponseEntity<List<TransactionResponse>> findAllTransactions()
    {
        return ResponseEntity.ok(transactionService.findAll());

    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @RequestBody @Valid TransactionRequest transactionRequest){

        return ResponseEntity.ok(transactionService.createTransaction(transactionRequest));
    }

}
