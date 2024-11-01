package com.almostsagar.blog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Builder(toBuilder = true)
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User commenter;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "postId", nullable = false)
    private Post fkPostId;

    @Temporal(TemporalType.DATE)
    @Column(name = "comment_created", columnDefinition = "datetime")
    private Date commentCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "comment_modified", columnDefinition = "datetime")
    private Date commentModified;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1) default 0")
    @Builder.Default
    private Boolean isDeleted = false;

    @Column(name = "comment_approved", columnDefinition = "tinyint(1) default 1")
    @Builder.Default
    private Boolean commentApproved = true;

    @PrePersist
    protected void onCreate() {
        commentCreated = new Date();
        commentModified = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        commentModified = new Date();
    }
}
