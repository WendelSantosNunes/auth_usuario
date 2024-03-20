package com.auth.auth.domain.user;

import jakarta.validation.constraints.NotBlank;

public record LoginResponseDTO(@NotBlank(message = "O campo token não pode ser nulo.") String token) {
}
