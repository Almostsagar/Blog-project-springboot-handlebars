package com.almostsagar.handlebars.blog.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.handlebars.blog.entities.Tag;
import com.almostsagar.handlebars.blog.services.TagService;
import com.almostsagar.handlebars.blog.entities.Post;

@Validated
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class TagController {
    private final TagService tagService;

    @GetMapping("/{postId}/tags")
    public LinkedList<Tag> getTagsByPostId(@PathVariable(value = "postId") Integer postId) {
        log.info("Inside TagController -> getTagsByPostId() for postId : " + postId);
        Post post = Post.builder().postId(postId).build();
        return tagService.getTagsByPost(post);
    }
}
