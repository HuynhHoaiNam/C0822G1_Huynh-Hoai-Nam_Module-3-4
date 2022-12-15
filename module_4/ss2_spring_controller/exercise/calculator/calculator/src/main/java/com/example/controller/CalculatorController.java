package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/home")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("")
    public String calculate() {
        return "/calculator/calculator";
    }


    @PostMapping("/result")
    public String result(Model model, @RequestParam("firstValue") double firstValue,
                         @RequestParam("secondValue") double secondValue, @RequestParam("nameCheck") String nameCheck) {
        double result = calculatorService.calculationResults(firstValue, secondValue, nameCheck);
        model.addAttribute("result", result);
        return "/calculator/result";
    }
}
