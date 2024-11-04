package com.almostsagar.blog.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.blog.entities.User;
import com.almostsagar.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        log.info("Inside UserController -> register() method");
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        return userService.registerUser(user);
    }

}
