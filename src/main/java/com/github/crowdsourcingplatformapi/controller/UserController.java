package com.github.crowdsourcingplatformapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class UserController {
//    @Autowired
//    private User
    @PostMapping("/users")
    public ResponseEntity<?> registerNewUser(@RequestBody List<String> skills){
//        throw new EntityNotFoundException();
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Request body was invalid");
    }
}
