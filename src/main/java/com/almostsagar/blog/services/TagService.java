package com.almostsagar.blog.services;

import java.util.LinkedList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.almostsagar.blog.entities.Post;
import com.almostsagar.blog.entities.Tag;
import com.almostsagar.blog.repositories.TagRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public LinkedList<Tag> getTagsByPost(Post post) {
        return tagRepository.findByFkPostId(post);
    }

    public LinkedList<Post> getPostsBasedOnTagName(String tagName) {
        LinkedList<Tag> tags = tagRepository.findByTagName(tagName);
        LinkedList<Post> posts = tags.stream()
                .map(Tag::getFkPostId)
                .collect(Collectors.toCollection(LinkedList::new));
        return posts;
    }
}
