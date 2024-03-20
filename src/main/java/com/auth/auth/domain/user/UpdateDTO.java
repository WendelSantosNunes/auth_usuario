package com.auth.auth.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.") String name,
        @NotBlank(message = "O campo email não pode ser nulo.") String email,
        @NotBlank(message = "O campo telefone não pode ser nulo e tem que ter 11 dígitos.") @Size(min=11, max=11) String phone,
        @NotBlank(message = "O campo senha não pode ser nulo.") String password,
        @NotBlank(message = "O campo papel não pode ser nulo.") UserRole role) {
}
