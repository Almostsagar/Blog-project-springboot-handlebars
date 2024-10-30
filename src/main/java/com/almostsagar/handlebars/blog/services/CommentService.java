package com.almostsagar.handlebars.blog.services;

import java.util.LinkedList;
import org.springframework.stereotype.Service;

import com.almostsagar.handlebars.blog.entities.Comment;
import com.almostsagar.handlebars.blog.entities.Post;
import com.almostsagar.handlebars.blog.repositories.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /*
     * Get all comments
     */
    public LinkedList<Comment> getCommentsByPost(Post post) {
        LinkedList<Comment> comments = commentRepository.findByFkPostId(post);

        // return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());

        return comments;
    }
}
