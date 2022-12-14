package com.example.controller;


import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("")
    public String convertUSD() {
        return "currency-conversion/calculation";
    }

    @PostMapping("/convert")
    public String result(Model model, @RequestParam(name = "usd") double USD) {
        double result = convertService.convert(USD);
        model.addAttribute("result", result);
        return "currency-conversion/result";
    }
}
