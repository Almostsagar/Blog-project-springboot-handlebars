package com.almostsagar.blog.services;

import java.util.LinkedList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Boolean approveOrRejectPostComment(Integer postId, Integer commentId, Boolean apporve) {
        return commentRepository.setCommentApprovedForCommentId(apporve, commentId, postId) > 0 ? true : false;
    }
}
