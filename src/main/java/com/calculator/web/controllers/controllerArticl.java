package com.calculator.web.controllers;

import com.calculator.web.models.article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.calculator.web.repo.PostRepository;

@Controller
public class controllerArticl {

    @Autowired

    private PostRepository articleRepository;
       @GetMapping("/Articles")
       public String ArticleMain(Model model) {
           Iterable<article> articl = articleRepository.findAll();
            model.addAttribute("articles", articl);
            return "Articles";
        }
}
