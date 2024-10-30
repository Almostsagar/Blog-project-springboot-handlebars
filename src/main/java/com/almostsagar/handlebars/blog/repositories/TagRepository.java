package com.almostsagar.handlebars.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.LinkedList;

import com.almostsagar.handlebars.blog.entities.Tag;
import com.almostsagar.handlebars.blog.entities.Post;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    LinkedList<Tag> findByFkPostId(Post post);
}
