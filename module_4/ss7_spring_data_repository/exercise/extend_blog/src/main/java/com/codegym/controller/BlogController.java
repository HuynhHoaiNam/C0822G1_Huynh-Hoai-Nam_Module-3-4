package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "name", defaultValue = "") String name, @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogPage = blogService.listSort(pageable);
        model.addAttribute("blogList", blogPage);
        return "views/blog/list";
    }

    @GetMapping("listCategory")
    public String showList(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "views/blog/list-category";
    }


    @PostMapping("/delete")
    public String deleteBlog(int id) {
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", categoryService.findAll());
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
        model.addAttribute("categorys", categoryService.findAll());
        return "views/blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog) {
        blogService.edit(blog);
        return "redirect:/";
    }

    @GetMapping("/find")
    public String findByName() {
        return "/list";
    }


    @GetMapping("/showUpdateCategory/{id}")
    public String showUpdateCategory(Model model, @PathVariable("id") int id) {
        model.addAttribute("category", categoryService.findAllById(id));
        return "views/blog/update-catogary";
    }

    @PostMapping("/update-category")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.edit(category);
        return "redirect:/";
    }

    @GetMapping("/showCreateCategory")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "views/blog/create-category";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/";
    }

}
