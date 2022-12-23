package com.codegym.controller;


import com.codegym.model.Song;
import com.codegym.model.SongDto;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/list";
    }

    @GetMapping("/showCreate")
    public String showCreat(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("userDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("showUpdate/{id}")
    public String showUpdate(@Validated @PathVariable("id") int id, Model model) {
        Optional<Song> song = songService.findAllById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "update";
    }

    @PostMapping("update")
    public String update(@Validated @ModelAttribute("userDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Song song= new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.update(song);
        return "redirect:/";
    }

}
