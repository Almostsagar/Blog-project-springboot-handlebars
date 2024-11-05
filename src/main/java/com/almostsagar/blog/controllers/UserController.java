package com.almostsagar.blog.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.blog.entities.Role;
import com.almostsagar.blog.entities.User;
import com.almostsagar.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/users")
    public Page<User> getUsers(@RequestParam Integer pageNumber) {
        log.info("Inside UserController -> getUsers() method");
        pageNumber = pageNumber != null ? pageNumber : 0;
        return userService.getUsers(pageNumber);
    }

    @GetMapping("/getUsersByRole")
    public List<User> getUsersByRole(@RequestParam Integer roleId) {
        log.info("Inside UserController -> getUsersByRole() method for role " + roleId);
        Role role = new Role().toBuilder().roleId(roleId).build();
        return userService.getUsersByRole(role);
    }
    

}
