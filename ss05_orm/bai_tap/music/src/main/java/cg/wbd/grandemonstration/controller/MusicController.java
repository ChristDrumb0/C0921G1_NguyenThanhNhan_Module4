package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("musics")
public class MusicController {
    @Autowired
    private IService service;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("music/list");
        List<Music> music = service.findAll();
        modelAndView.addObject("music", music);
        return modelAndView;
    }

    @GetMapping("/info/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("music/info");
        Music music = service.findOne(id);
        modelAndView.addObject("music", music);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateMusic(Music music, RedirectAttributes attributes) {
        service.save(music);
        attributes.addFlashAttribute("messager","Update music successfully");
        return "redirect:/musics";
    }

    @GetMapping("/create-music")
    public ModelAndView showCreate(){
        ModelAndView mv = new ModelAndView("/music/create");
        mv.addObject("music",new Music());
        return mv;
    }

    @PostMapping("/save")
    public String saveMusic(Music music, RedirectAttributes attributes) {
        service.save(music);
        attributes.addFlashAttribute("messager","New music created successfully");
        return "redirect:/musics";
    }
//    @PostMapping("/create-music")
//    public ModelAndView saveCreate(@ModelAttribute("music") Music music){
//        service.save(music);
//        ModelAndView modelAndView = new ModelAndView("/music/create");
//        modelAndView.addObject("music", new Music());
//        modelAndView.addObject("messager", "New music created successfully");
//        return modelAndView;
//    }

}
