package com.almostsagar.blog.controllers;

import java.util.LinkedList;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.blog.entities.Category;
import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.services.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{postId}/categories")
    public LinkedList<Category> getCategoryByPostId(@PathVariable(value = "postId") Integer postId) {
        log.info("Inside CategoryController -> getCategoryByPostId() for postId : " + postId);
        Post post = Post.builder().postId(postId).build();
        return categoryService.getCategoryByPost(post);
    }
}
