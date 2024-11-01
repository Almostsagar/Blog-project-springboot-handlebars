package com.almostsagar.blog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder(toBuilder = true)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role fkRoleId;

    @Column(name = "user_profile_pic")
    private String userProfilePic;

    @Column(name = "user_bio")
    private String userBio;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_created", updatable = false, nullable = false, columnDefinition = "datetime")
    private Date userCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_modified", nullable = false, columnDefinition = "datetime")
    private Date userModified;

    @Column(name = "is_active", columnDefinition = "tinyint(1) default '1'")
    @Builder.Default
    private Boolean isActive = true;

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
