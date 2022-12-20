package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


@Controller
@RequestMapping("/home")
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = productService.productList();
        model.addAttribute("productList", productList);
        return "/product/list";
    }

    @GetMapping("/showCreate")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/home/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        boolean check = productService.delete(id);
        String mess = "Xoá thành công";
        if (!check) {
            mess = "Xoá Thất Bại";
        }
        redirectAttributes.addFlashAttribute("messDelete", mess);
        return "redirect:/home/list";
    }

    @GetMapping("/find")
    public String findByName(String name, Model model) {
        List<Product> productList = productService.findByName(name);
        model.addAttribute("productList", productList);
        return "/product/list";
    }



    @GetMapping("/showUpdate/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/update";
    }


    @PostMapping("/update")
    public String updateProduct(RedirectAttributes redirectAttributes, @ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/home/list";
    }

}
