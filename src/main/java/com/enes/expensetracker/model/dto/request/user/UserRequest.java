package com.enes.expensetracker.model.dto.request.user;

import jakarta.validation.constraints.*;

public record UserRequest(

        Long id,

        @NotNull(message = "User firstname can not be null.")
        @Size(min = 2, max = 50, message = "FirstName must be between 2 and 50 characters.")
        String firstName,

        @NotNull(message = "User lastname can not be null.")
        @Size(min = 2, max = 50, message = "Lastname must be between 2 and 50 characters.")
        String lastName,

        @NotNull(message = "User email can not be null.")
        @Email(message = "User email is not a valid email address")
        String email,

        @NotNull(message = "Password can not be null.")
        @Size(min = 8, message = "Password must be at least 8 characters long.")
        @Pattern.List({
                @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least one digit."),
                @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase character."),
                @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase character."),
                @Pattern(regexp = "(?=.*[!@#$%^&*+=?-]).+", message = "Password must contain at least one special character.")
        })
        String password
) {
}
