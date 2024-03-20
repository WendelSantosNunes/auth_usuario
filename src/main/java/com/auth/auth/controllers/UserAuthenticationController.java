package com.auth.auth.controllers;

import com.auth.auth.domain.user.*;
import com.auth.auth.infra.security.TokenService;
import com.auth.auth.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.genereteToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity postRegister(@RequestBody RegisterDTO data){
        if(this.repository.findUserDetailsByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();

        String encruptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), data.phone(), encruptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-user")
    public ResponseEntity putUser(@RequestBody UpdateDTO data, @RequestHeader("Authorization") String token) {
        token = token.replace("Bearer ", "");

        DecodedJWT jwt = JWT.decode(token);
        String currentUsername = jwt.getSubject();
        String currentUserRole = jwt.getClaim("role").asString();

        if(!currentUsername.equals(data.email()) && !currentUserRole.equals("ADMIN")){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        System.out.println("Passou");

        User userNew = this.repository.findByEmail(data.email());

        if(userNew == null){
            return ResponseEntity.badRequest().build();
        }

        String encruptedPassword = new BCryptPasswordEncoder().encode(data.password());

        userNew.setEmail(data.email());
        userNew.setPhone(data.phone());
        userNew.setPassword(encruptedPassword);
        userNew.setRole(data.role());
        userNew.setName(data.name());

        this.repository.save(userNew);

        return ResponseEntity.ok().build();
    }
}
