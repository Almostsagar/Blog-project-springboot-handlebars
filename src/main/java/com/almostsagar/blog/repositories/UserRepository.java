package com.almostsagar.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almostsagar.blog.entities.Role;
import com.almostsagar.blog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    List<User> findByFkRoleId(Role role);

}
