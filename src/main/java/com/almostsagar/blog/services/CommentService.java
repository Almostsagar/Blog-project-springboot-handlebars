package com.almostsagar.blog.services;

import java.util.LinkedList;
import org.springframework.stereotype.Service;

import com.almostsagar.blog.entities.Comment;
import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.repositories.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /*
     * Get all comments for a post
     */
    public LinkedList<Comment> getCommentsByPost(Post post) {
        return commentRepository.findByFkPostId(post);
    }

    public Comment savePostComment(Comment commentObj) {
        return commentRepository.save(commentObj);
    }
}
