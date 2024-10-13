package com.enes.expensetracker.model.dto.response.transaction;

import java.math.BigDecimal;

public record TransactionResponse (


        String description,

        BigDecimal amount,

        Long userid
){



}
