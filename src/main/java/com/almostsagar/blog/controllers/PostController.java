package com.almostsagar.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.almostsagar.blog.entities.Post;

@Controller
public class PostController {
    @GetMapping(value = { "hello" })
    public String Test(Model model) {
        // Category category = Category.builder()
        // .categoryName("Sample Category")
        // .categoryStatus(Status.NEW)
        // .isActive(true)
        // .build();

        // Comment comment = Comment.builder()
        // .comment("Hey")
        // .build();

        Post post = Post.builder().postBody("LLO:").build();
        model.addAttribute("simpleMsg", post.toString());
        return "hello";
    }
}
