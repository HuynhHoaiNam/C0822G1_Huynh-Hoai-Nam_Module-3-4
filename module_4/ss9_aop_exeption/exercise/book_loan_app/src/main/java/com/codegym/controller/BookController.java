package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/showList")
    public String showList(Model model, @PageableDefault(size = 3) Pageable pageable) {
        Page<Book> bookPage = bookService.showList(pageable);
        model.addAttribute("bookPage", bookPage);
        return "/list";
    }
}
