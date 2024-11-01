package com.almostsagar.blog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.entities.Tag;

import java.util.LinkedList;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    LinkedList<Tag> findByFkPostId(Post post);
}
