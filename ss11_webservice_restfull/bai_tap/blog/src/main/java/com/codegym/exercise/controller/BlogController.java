package com.codegym.exercise.controller;

import com.codegym.exercise.entity.Blog;
import com.codegym.exercise.service.blog.IBlogService;
import com.codegym.exercise.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
@Controller
public class BlogController {
    @Autowired
    private IBlogService service;
    @Autowired
    private ICategoryService cateService;

    //list
    @GetMapping
    private String showList(Optional<String> title_search,
                            Optional<Long> cate_filter,
                            Model model,
                            @PageableDefault(size=2) Pageable pageable

    ){
        model.addAttribute("categoryList",cateService.findAll());
        // search theo truong hop:
        // no title
        if (!title_search.isPresent() || title_search.get().equals("")){
            //no cate
            if(!cate_filter.isPresent()){
                model.addAttribute("blogList",service.findAll(pageable));
            }
            // yes Cate
            else{
                model.addAttribute("cate_filter", cate_filter.get());
                model.addAttribute("blogList",service.findByCategory(cate_filter.get(),pageable));
            }
        }
        //yes Title
        else{
            //no cate
            if(!cate_filter.isPresent()){
                model.addAttribute("title_search", title_search.get());
                model.addAttribute("blogList",service.findByTitle(title_search.get(),pageable));
            }
            //yes Cate
            else{
                model.addAttribute("cate_filter", cate_filter.get());
                model.addAttribute("title_search", title_search.get());
                model.addAttribute("blogList",service.findBlogByTitleContainingAndCategoryId(title_search.get(),cate_filter.get(),pageable));
            }
        }

        return "list";
    }

    //edit & view
    @GetMapping("/{id}/view_blog")
    private String showInfor(@PathVariable Long id, Model model){
        Blog blog = service.findById(id).get();
        model.addAttribute("categoryList",cateService.findAll());
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
        model.addAttribute("categoryList",cateService.findAll());
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
    private String deleteBlog(@PathVariable Long id, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("messagesDelete", "Delete Blog success!");
        service.remove(id);
        return "redirect:/blog";
    }
}
