package com.auth.auth.domain.user;

public record UpdateDTO(String name, String email, String phone, String password, UserRole role) {
}
