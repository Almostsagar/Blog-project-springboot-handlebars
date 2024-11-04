package com.almostsagar.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.almostsagar.blog.entities.Comment;
import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.entities.User;
import com.almostsagar.blog.services.CommentService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Validated
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}/comments")
    public LinkedList<Comment> getCommentsByPostId(@PathVariable(value = "postId") Integer postId) {
        log.info("Inside CommentController -> getCommentsByPostId() for postId : " + postId);
        Post post = new Post().toBuilder()
                .postId(postId)
                .build();
        return commentService.getCommentsByPost(post);
    }

    @PostMapping("/{postId}/saveComment")
    public Comment savePostComment(@RequestBody @Validated ObjectNode json,
            @PathVariable(value = "postId") Integer postId) {
        postId = (json.get("postId").asInt() == postId)
                ? json.get("postId").asInt()
                : null;
        Integer userId = json.get("userId").asInt();
        String comment = json.get("comment").asText();
        if (postId == null || userId == null || StringUtils.isBlank(comment)) {
            throw new IllegalArgumentException("postId or userId or comment is null/empty");
        }
        log.info("Inside CommentController -> savePostComment() for postId : " + json.get("postId").asText());
        Post post = new Post().toBuilder()
                .postId(postId)
                .build();
        User user = new User().toBuilder()
                .userId(userId)
                .build();
        Comment commentObj = new Comment().toBuilder()
                .comment(comment)
                .fkPostId(post)
                .commenter(user)
                .build();
        return commentService.savePostComment(commentObj);
    }

    @PostMapping("/{postId}/approveOrRejectComment")
    public Boolean approveOrRejectPostComment(@RequestBody @Validated ObjectNode json) {
        Integer postId = json.get("postId").asInt();
        Integer commentId = json.get("commentId").asInt();
        Boolean approve = json.get("approve").asBoolean();
        return commentService.approveOrRejectPostComment(postId, commentId, approve);
    }
}
