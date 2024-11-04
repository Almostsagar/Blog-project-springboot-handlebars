package com.almostsagar.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.almostsagar.blog.entities.User;
import com.almostsagar.blog.entities.UserPrinciple;
import com.almostsagar.blog.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceCustom implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        log.info(user + " ");
        if (user == null) {
            log.info("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrinciple(user);
    }

}
