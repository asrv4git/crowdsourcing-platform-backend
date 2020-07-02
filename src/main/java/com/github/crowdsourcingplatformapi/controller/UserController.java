package com.github.crowdsourcingplatformapi.controller;

import com.github.crowdsourcingplatformapi.entity.User;
import com.github.crowdsourcingplatformapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/exception")
    public void throwException() throws Exception {
        throw new IllegalArgumentException();
    }
}
