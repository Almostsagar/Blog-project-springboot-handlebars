package com.almostsagar.handlebars.blog.entities;

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
    @Column(name = "comment_created")
    private Date commentCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "comment_modified")
    private Date commentModified;

    @Column(name = "is_deleted", columnDefinition = "varchar(255) default '0'")
    private Boolean isDeleted;
}
