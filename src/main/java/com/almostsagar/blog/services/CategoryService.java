package com.almostsagar.blog.services;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.almostsagar.blog.entities.Category;
import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public LinkedList<Category> getCategoryByPost(Post post) {
        return categoryRepository.getByCategoryId(post.getPostCategory().getCategoryId());
    }

}
