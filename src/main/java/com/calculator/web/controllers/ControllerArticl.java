package com.calculator.web.controllers;

import com.calculator.web.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.calculator.web.repo.PostRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ControllerArticl {

    @Autowired

    private PostRepository articleRepository;
       @GetMapping("/Articles")
       public String ArticleMain(Model model) {
           Iterable<Article> articl = articleRepository.findAll();
            model.addAttribute("articles", articl);
            return "Articles";
        }

    @GetMapping("/Articles/add")
    public String Articleaddd(Model model) {
        model.addAttribute("articles", "Articles-add");
        return "Articles-add";
    }
    @PostMapping("/Articles/add")
    public String Articleaddpost(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
           Article articlee = new Article(title, anons, full_text);
           articleRepository.save(articlee);
           return "redirect:/Articles";
    }
    @GetMapping("/Articles/{id}")
    public String ArticleDetails(@PathVariable(value = "id") long id, Model model) {
           if(!articleRepository.existsById(id)) {
               return "redirect:/Articles";
           }
        Optional<Article> articlee = articleRepository.findById(id);
        ArrayList<Article> art = new ArrayList<>();
        articlee.ifPresent(art::add);
        model.addAttribute("articlee", art);
        return "Articles-details";
    }
    @GetMapping("/Articles/{id}/edit")
    public String ArticleEdit(@PathVariable(value = "id") long id, Model model) {
        if(!articleRepository.existsById(id)) {
            return "redirect:/Articles";
        }
        Optional<Article> articlee = articleRepository.findById(id);
        ArrayList<Article> art = new ArrayList<>();
        articlee.ifPresent(art::add);
        model.addAttribute("articlee", art);
        return "Articles-edit";
    }

    @PostMapping("/Articles/{id}/edit")
    public String ArticleEditpost(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Article articlee = articleRepository.findById(id).orElseThrow();
        articlee.setTitle(title);
        articlee.setAnons(anons);
        articlee.setFull_text(full_text);
        articleRepository.save(articlee);
        return "redirect:/Articles";
    }
    @PostMapping("/Articles/{id}/remove")
    public String ArticleDel(@PathVariable(value = "id") long id, Model model){
        Article articlee = articleRepository.findById(id).orElseThrow();
        articleRepository.delete(articlee);
        return "redirect:/Articles";
    }
}
