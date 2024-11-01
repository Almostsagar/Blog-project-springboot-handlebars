package com.almostsagar.blog.services;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.entities.Tag;
import com.almostsagar.blog.repositories.TagRepository;

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
