package com.enes.expensetracker.exception.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String,String> errors
) {
}
