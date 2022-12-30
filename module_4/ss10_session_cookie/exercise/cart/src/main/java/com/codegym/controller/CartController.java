package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
public class CartController {
    @GetMapping(value = "/show-cart")
    public String showCart(@SessionAttribute("cart")Cart cart, Model model) {
        Map<Product, Integer> productMap = cart.getProductMap();
        model.addAttribute("productMap", productMap);
        return "cart";
    }
}
