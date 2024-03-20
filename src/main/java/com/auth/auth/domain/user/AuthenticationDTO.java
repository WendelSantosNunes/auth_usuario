package com.auth.auth.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "O campo email não pode ser nulo.") String email,
        @NotBlank(message = "O campo senha não pode ser nulo.") String password) {
}
