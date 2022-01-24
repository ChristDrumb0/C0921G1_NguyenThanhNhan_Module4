package com.codegym.song.controller;

import com.codegym.song.dto.SongDto;
import com.codegym.song.entity.Song;
import com.codegym.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping
    public String showSong(Model model,
                           @PageableDefault(size=2) Pageable pageable){
        model.addAttribute("songList",songService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("create","songDto",new SongDto());
    }

    @PostMapping("create")
    public String createSong(@Valid @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("songDto",songDto);
            return "create";
        }
        else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("messageCreate","Create the song" + song.getName() + " successfully!");
            return "redirect:/song";
        }

    }
    @GetMapping("/{id}/update")
    public ModelAndView showEdit(@PathVariable Integer id){

        Song song = songService.findById(id).get();
        //copy song to songDto
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        //render to view
        return new ModelAndView("update","songDto",new SongDto());
    }

    @PostMapping("/update")
    public String updateSong(@Valid @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("songDto",songDto);
            return "update";
        }
        else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("messageEdit","Update the song" + song.getName() + " successfully!");
            return "redirect:/song";
        }

    }

    @GetMapping("/{id}/delete")
    private String deleteBlog(@PathVariable Integer id, @ModelAttribute Song song, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("messagesDelete", "Delete Blog success!");
        songService.delete(id);
        return "redirect:/song";
    }
}
