package com.almostsagar.handlebars.blog.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment")
    private String comment;

    @OneToOne
    @JoinColumn(name = "commenter", referencedColumnName = "user_id")
    private User commenter;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post fkPostId;

    @Column(name = "comment_created")
    private Date commentCreated;

    @Column(name = "comment_modified")
    private Date commentModified;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
