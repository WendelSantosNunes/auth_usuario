package com.auth.auth.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name="user_auth")
@Entity(name="user_auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
