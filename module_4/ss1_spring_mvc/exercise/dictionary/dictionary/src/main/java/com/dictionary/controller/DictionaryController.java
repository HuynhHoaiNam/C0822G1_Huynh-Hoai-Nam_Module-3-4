package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String chekInput(){
        return "/dictionary/dictionary-input";
    }

    @PostMapping("/result")
    public String resultWord(Model model,@RequestParam(name = "wordInput") String wordInput){
        String result=dictionaryService.checkWord(wordInput);
        if (result==null){
            String mess="Lỗi. Không có trong từ điển";
            model.addAttribute("mess",mess);
        }else {
            model.addAttribute("result",result);
        }
        return "/dictionary/result";
    }
}
