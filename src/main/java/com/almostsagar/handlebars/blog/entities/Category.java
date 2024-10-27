package com.almostsagar.handlebars.blog.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_status", nullable = false)
    private Status categoryStatus;

    @Column(name = "is_active", nullable = false, columnDefinition = "varchar(255) default '1'")
    private Boolean isActive;
}
