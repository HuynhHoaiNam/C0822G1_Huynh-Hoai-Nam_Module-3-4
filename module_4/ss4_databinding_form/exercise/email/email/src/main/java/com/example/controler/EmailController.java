package com.example.controler;

import com.example.model.Email;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("")
    public String showList(Model model) {
        List<Email> emailList = emailService.emailList();
        model.addAttribute("emailList", emailList);
        return "/email/list";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(Model model, @PathVariable("id") int id) {
        Email email = emailService.findById(id);
        model.addAttribute("email", email);

        List<String> languageList = emailService.languageList();
        model.addAttribute("languageList", languageList);

        List<Integer> pageSizeList = emailService.pageSizeList();
        model.addAttribute("pageSizeList", pageSizeList);
        return "/email/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("email") Email email, Model model, RedirectAttributes redirectAttributes) {
        emailService.edit(email);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/home";
    }
}
