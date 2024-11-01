package com.almostsagar.blog.services;

import org.springframework.stereotype.Service;

import com.almostsagar.blog.entities.User;
import com.almostsagar.blog.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

}
