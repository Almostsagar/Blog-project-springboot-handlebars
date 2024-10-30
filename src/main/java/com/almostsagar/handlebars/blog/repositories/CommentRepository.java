package com.almostsagar.handlebars.blog.repositories;

import java.util.LinkedList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almostsagar.handlebars.blog.entities.Comment;
import com.almostsagar.handlebars.blog.entities.Post;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    LinkedList<Comment> findByFkPostId(Post post);
}
