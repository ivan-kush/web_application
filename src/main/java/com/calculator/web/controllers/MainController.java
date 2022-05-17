package com.calculator.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
public String home( Model model) {
    model.addAttribute("title", "Главная страница");
    return "home";

}
    @GetMapping("/About")
    public String About( Model model) {
        model.addAttribute("title", "About");
        return "About";

    }

    @GetMapping("/FAQs")
    public String FAQsMain(Model model) {
        model.addAttribute("title", "FAQs");
        return "FAQs";
    }

    @GetMapping("/Calculator")
    public String Calculator(Model model) {
        model.addAttribute("title", "Calculator");
        return "Calculator";
    }
    @GetMapping("/SignIn")
    public String SignIn(Model model) {
        model.addAttribute("title", "SignIn");
        return "SignIn";
    }
}




