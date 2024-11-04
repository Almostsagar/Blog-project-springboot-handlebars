package com.almostsagar.blog.services;

import java.util.LinkedList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.almostsagar.blog.constants.BlogConstants;
import com.almostsagar.blog.entities.Category;
import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.repositories.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public LinkedList<Post> getPostByCategoryId(Category category) {
        return postRepository.findByPostCategory(category);
    }

    public Page<Post> getPosts(Integer pageNumber) {
        return postRepository.findAll(PageRequest.of(pageNumber, BlogConstants.PAGE_SIZE));
    }

}
