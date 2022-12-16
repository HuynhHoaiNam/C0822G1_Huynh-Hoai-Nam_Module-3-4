package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class SandwichRController {

    @GetMapping("")
    public String showLis() {
        return "/sandwich/check-box-sandwich";
    }

    @PostMapping("/result")
    public String result(Model model, @RequestParam("nameCheck") String[] nameCheck ) {
        model.addAttribute("nameCheck", nameCheck);
        return "/sandwich/selected-list";
    }

}
