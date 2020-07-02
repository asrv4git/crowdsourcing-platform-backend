package com.github.crowdsourcingplatformapi.service;

import com.github.crowdsourcingplatformapi.entity.User;
import com.github.crowdsourcingplatformapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(@NotNull User user) {
        return userRepository.save(user);
    }
}
