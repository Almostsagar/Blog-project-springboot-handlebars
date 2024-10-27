package com.almostsagar.handlebars.blog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    // @GetMapping(value = { "/", "hello" })
    // public String greetMessage(Model model) {
    //     String helloworld = "Hello and welcome to mustache";
    //     model.addAttribute("simpleMsg", helloworld);
    //     model.asMap().forEach((k, v) -> logger.info("Key: {}, Value: {}, Type: {}", k, v, v.getClass().getName()));
    //     return "hello";
    // }
}
