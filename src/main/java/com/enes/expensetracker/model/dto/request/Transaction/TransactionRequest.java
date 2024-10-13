package com.enes.expensetracker.model.dto.request.Transaction;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record TransactionRequest (


        @NotNull(message = "Transaction description can not be null.")
        @Size(min = 2, max = 100, message = "Description must be between 2 and 100 characters.")
        String Description,

        @Positive(message = "Amount must be positive.")
        @Max(value = 99999, message = "Amount must be realistic")
        BigDecimal Amount,

        @NotNull(message = "User id can not be null.")
        Long userid
){
}
