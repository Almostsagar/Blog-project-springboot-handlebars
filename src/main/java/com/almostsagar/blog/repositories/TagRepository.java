package com.almostsagar.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.entities.Tag;

import java.util.LinkedList;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    LinkedList<Tag> findByFkPostId(Post post);

    LinkedList<Tag> findByTagName(String tagName);
}
