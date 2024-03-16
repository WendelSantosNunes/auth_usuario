package com.auth.auth.domain.user;

public record RegisterDTO(String name, String email, String phone, String password, UserRole role) {
}
