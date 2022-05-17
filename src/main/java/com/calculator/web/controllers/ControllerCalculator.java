package com.calculator.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCalculator {
    @GetMapping("/Calculat")
    public String Calculat(Model model) {
        model.addAttribute("title", "Calculat");
        return "Calculat";
    }
}
