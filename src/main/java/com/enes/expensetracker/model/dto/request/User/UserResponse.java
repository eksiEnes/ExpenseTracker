package com.enes.expensetracker.model.dto.request.User;

import com.enes.expensetracker.model.Transaction;

import java.util.List;

public record UserResponse(

        String firstName,
        String lastName,
        String email

) {
}
