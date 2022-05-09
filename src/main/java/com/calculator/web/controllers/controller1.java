package com.calculator.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller1 {
    @GetMapping("/FAQs")
    public String FAQsMain(Model model) {
        return "FAQs";
    }
}
