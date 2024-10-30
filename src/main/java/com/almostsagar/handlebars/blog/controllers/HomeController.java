package com.almostsagar.handlebars.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {                      
        model.addAttribute("mess", "Welcome to the Home Page!");
        return "default/index";                       
    }
}
