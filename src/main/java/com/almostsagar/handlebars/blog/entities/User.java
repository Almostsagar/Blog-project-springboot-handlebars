package com.almostsagar.handlebars.blog.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
@ToString
@Builder(toBuilder = true)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role fk_role_id;

    @Column(name = "user_created", updatable = false, nullable = false)
    private Date userCreated;

    @Column(name = "user_modified", nullable = false)
    private Date userModified;

    @Column(name = "is_active", columnDefinition = "varchar(255) default '1'")
    private Boolean isActive;

    @PrePersist
    protected void onCreate() {
        userCreated = new Date();
        userModified = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        userModified = new Date();
    }
}
