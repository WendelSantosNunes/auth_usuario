package com.auth.auth.controllers;

import com.auth.auth.domain.user.User;
import com.auth.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody User obj){
        repository.save(obj);
        return ResponseEntity.ok().build();
    }
}
