package com.ify.api.controller;

import com.ify.api.dto.UserRequest;
import com.ify.api.entity.User;
import com.ify.api.exception.UserNotFoundException;
import com.ify.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User>saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.of(Optional.ofNullable(service.getAllUsers()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

}
