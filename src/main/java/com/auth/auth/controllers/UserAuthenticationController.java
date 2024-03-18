package com.auth.auth.controllers;

import com.auth.auth.domain.user.AuthenticationDTO;
import com.auth.auth.domain.user.LoginResponseDTO;
import com.auth.auth.domain.user.RegisterDTO;
import com.auth.auth.domain.user.User;
import com.auth.auth.infra.security.TokenService;
import com.auth.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class UserAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity postUser(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        System.out.println(usernamePassword);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        System.out.println("Hello 2");
        System.out.println(auth);
        var token = tokenService.genereteToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
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
