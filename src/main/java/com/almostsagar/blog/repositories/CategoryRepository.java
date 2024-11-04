package com.almostsagar.blog.repositories;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;

import org.springframework.data.repository.CrudRepository;

import com.almostsagar.blog.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    LinkedList<Category> getByCategoryId(Integer categoryId);

    LinkedList<Category> findByCategoryName(String categoryName);

}
