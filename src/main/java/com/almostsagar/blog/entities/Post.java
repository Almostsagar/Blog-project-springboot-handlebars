package com.almostsagar.blog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Builder(toBuilder = true)
@Table(name = "post", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "post_title", "user_id", "category_id" })
})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_body", columnDefinition = "LONGTEXT")
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

    @OneToMany(targetEntity = Tag.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fkPostId")
    @ToString.Exclude
    @JsonManagedReference
    private Set<Tag> postTags;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status", nullable = false)
    private Status postStatus;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fkPostId")
    @ToString.Exclude
    private Set<Comment> postComments;

    private Integer postViews;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User postAuthor;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created", nullable = false, columnDefinition = "datetime")
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_modified", nullable = false, columnDefinition = "datetime")
    private Date dateModified;

    @Column(name = "is_comment_approval_req", columnDefinition = "tinyint(1) default 0")
    @Builder.Default
    private Boolean isCommentApprovalRequired = false;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1) default 0")
    @Builder.Default
    private Boolean isDeleted = false;

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
