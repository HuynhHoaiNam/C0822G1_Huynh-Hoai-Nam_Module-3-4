package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setCart() {
        return new Cart();
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = productService.showList();
        model.addAttribute("productList", productList);
        return "/list";
    }


    @PostMapping("/add/{id}")
    public String addProduct(Model model, @SessionAttribute("cart") Cart cart, @PathVariable("id") int id) {
        Optional<Product> product = productService.findById(id);
        cart.addProduct(product.get());
        return "/list";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }
}
