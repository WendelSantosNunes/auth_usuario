package com.auth.auth.repositories;

import com.auth.auth.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    UserDetails findUserDetailsByEmail(String email);

}
