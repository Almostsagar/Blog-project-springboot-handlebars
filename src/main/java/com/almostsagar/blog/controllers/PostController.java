package com.almostsagar.blog.controllers;

import java.util.LinkedList;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.blog.entities.Category;
import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.services.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/category/{categoryId}")
    public LinkedList<Post> getPostByCategoryId(@PathVariable(value = "categoryId") Integer categoryId) {
        log.info("Inside PostController -> getPostByCategoryId() for categoryId : " + categoryId);
        Category category = new Category().toBuilder()
                .categoryId(categoryId)
                .build();
        return postService.getPostByCategoryId(category);
    }

    @GetMapping("/posts")
    public Page<Post> getPosts(@RequestParam Integer pageNumber) {
        log.info("Inside PostController -> getPosts()");
        return postService.getPosts(pageNumber);
    }

}
