package com.almostsagar.blog.repositories;

import java.util.LinkedList;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.almostsagar.blog.entities.Category;
import com.almostsagar.blog.entities.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

    LinkedList<Post> findByPostCategory(Category category);
    
}
