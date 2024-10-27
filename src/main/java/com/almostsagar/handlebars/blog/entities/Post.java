package com.almostsagar.handlebars.blog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_body")
    private String postBody;

    @Column(name = "post_summary")
    private String postSummary;

    @Column(name = "post_format", nullable = false)
    @Enumerated(EnumType.STRING)
    private Format postFormat;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category postCategory;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "image_title")
    private String imageTitle;

    @OneToMany(targetEntity = Tag.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "fkPostId")
    private Set<Tag> postTags;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status", nullable = false)
    private Status postStatus;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "fkPostId")
    private Set<Comment> postComments;

    private Integer postViews;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User postAuthor;

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "date_modified", nullable = false)
    private Date dateModified;

    @Column(name = "is_deleted", columnDefinition = "varchar(255) default '0'")
    private Boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
        dateModified = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateModified = new Date();
    }
}
