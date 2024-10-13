package com.enes.expensetracker.model.dto.request.Transaction;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record TransactionResponse (


        String Description,

        BigDecimal Amount,

        String email
){



}
