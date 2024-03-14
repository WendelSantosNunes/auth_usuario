package com.auth.auth.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name="user")
@Entity(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
