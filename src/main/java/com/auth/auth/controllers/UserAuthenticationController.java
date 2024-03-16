package com.auth.auth.controllers;

import com.auth.auth.domain.user.AuthenticationDTO;
import com.auth.auth.domain.user.RegisterDTO;
import com.auth.auth.domain.user.User;
import com.auth.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
public class UserAuthenticationController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity postUser(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        System.out.println(usernamePassword);

        var auth = this.authenticationManager.authenticate(usernamePassword);
        System.out.println(auth);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity postRegister(@RequestBody RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();

        String encruptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), data.phone(), encruptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
