package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IService service;

    //list
    @GetMapping
    private ModelAndView showList(){
        return new ModelAndView("list","blogList",service.findAll());
    }

    //edit & view
    @GetMapping("/{id}/view_blog")
    private String showInfor(@PathVariable Integer id, Model model){
        Blog blog = service.findById(id).get();

        model.addAttribute("blog",blog);

        return "view_edit";
    }
    @PostMapping("/update")
    private String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        service.save(blog);
        redirectAttributes.addFlashAttribute("messagesEdit","Update Blog: '" + blog.getTitle()+ "' success!");
        return "redirect:/blog";
    }

    //create
    @GetMapping("/create")
    private String showCreate(Model model){
        Blog blog = new Blog();
        model.addAttribute(blog);
        return "create";
    }
    @PostMapping("/create")
    private String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        service.save(blog);
        redirectAttributes.addFlashAttribute("messagesCreate", "Create Blog: '" + blog.getTitle() + "' success!");
        return "redirect:/blog";
    }

    //delete
    @GetMapping("/{id}/delete")
    private String deleteBlog(@PathVariable Integer id, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("messagesDelete", "Delete Blog success!");
        service.delete(id);
        return "redirect:/blog";
    }
}

