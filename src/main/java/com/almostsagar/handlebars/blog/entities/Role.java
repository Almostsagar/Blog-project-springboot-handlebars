package com.almostsagar.handlebars.blog.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;  // SUPER_ADMIN, ADMIN, AUTHOR, CONTRIBUTOR, SUBSCRIBER
}