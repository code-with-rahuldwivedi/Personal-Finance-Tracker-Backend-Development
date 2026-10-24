package com.zest.productapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public final class AuthDtos {

    private AuthDtos() {}

    public record RegisterRequest(
        @NotBlank(message = "Full name is required")
        @Size(max = 100, message = "Full name must be at most 100 characters")
        String fullName,

        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email")
        @Size(max = 150)
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 72,
              message = "Password must be 8 to 72 characters")
        String password,

        @Pattern(regexp = "^[A-Za-z]{3}$",
                 message = "Currency must be a 3-letter code")
        String preferredCurrency
    ) {}

    public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email")
        String email,

        @NotBlank(message = "Password is required")
        String password
    ) {}

    public record AuthResponse(
        String message,
        String tokenType,
        String accessToken,
        long expiresIn,
        Long userId,
        String fullName,
        String email
    ) {}
}
