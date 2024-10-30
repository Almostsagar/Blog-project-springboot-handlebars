package com.almostsagar.handlebars.blog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Builder(toBuilder = true)
@Table(name = "tag", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "tag_name", "post_id" })
})
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
    @JoinColumn(name = "postId", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Post fkPostId;
}
