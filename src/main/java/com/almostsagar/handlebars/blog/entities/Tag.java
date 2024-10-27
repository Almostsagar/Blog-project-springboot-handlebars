package com.almostsagar.handlebars.blog.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @Column(name = "tag_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status tagStatus;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post fkPostId;
}