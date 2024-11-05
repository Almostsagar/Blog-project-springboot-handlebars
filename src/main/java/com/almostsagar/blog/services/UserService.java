package com.almostsagar.blog.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.almostsagar.blog.constants.BlogConstants;
import com.almostsagar.blog.entities.Role;
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

    public Page<User> getUsers(Integer pageNumber) {
        return userRepository.findAll(PageRequest.of(pageNumber, BlogConstants.PAGE_SIZE));
    }

    public List<User> getUsersByRole(Role role) {
        return userRepository.findByFkRoleId(role);
    }

}
