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
@Table(name = "comment")
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
