package com.almostsagar.handlebars.blog.services;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.almostsagar.handlebars.blog.entities.Tag;
import com.almostsagar.handlebars.blog.entities.Post;
import com.almostsagar.handlebars.blog.repositories.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    /*
     * Get all tags
     */
    public LinkedList<Tag> getTagsByPost(Post post) {
        LinkedList<Tag> tags = tagRepository.findByFkPostId(post);
        return tags;
    }
}
