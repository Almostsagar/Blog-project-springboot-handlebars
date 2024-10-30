package com.almostsagar.handlebars.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.handlebars.blog.entities.Comment;
import com.almostsagar.handlebars.blog.entities.Post;
import com.almostsagar.handlebars.blog.services.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}/comments")
    public LinkedList<Comment> getCommentsByPostId(@PathVariable(value = "postId") Integer postId) {
        log.info("Inside CommentController -> getCommentsByPostId() for postId : " + postId);
        Post post = Post.builder().postId(postId).build();
        return commentService.getCommentsByPost(post);
    }
}
