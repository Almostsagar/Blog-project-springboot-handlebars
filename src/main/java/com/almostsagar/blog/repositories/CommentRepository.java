package com.almostsagar.blog.repositories;

import java.util.LinkedList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almostsagar.blog.entities.Comment;
import com.almostsagar.blog.entities.Post;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    LinkedList<Comment> findByFkPostId(Post post);
}
