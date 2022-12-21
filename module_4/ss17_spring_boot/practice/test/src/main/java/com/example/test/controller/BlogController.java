package com.example.test.controller;

import com.example.test.model.Blog;
import com.example.test.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "views/blog/list";
    }

    @PostMapping("/delete")
    public String deleteBlog(int id) {
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "views/blog/create-blog";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/detail-blog/{id}")
    public String detailBLog(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findAllById(id));
        return "views/blog/detail-blog";
    }

    @GetMapping("/showUpdate/{id}")
    public String showUpdate(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findAllById(id));
        return "views/blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog) {
        blogService.edit(blog);
        return "redirect:/";
    }
}
