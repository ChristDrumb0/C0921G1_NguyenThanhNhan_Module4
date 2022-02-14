package com.codegym.exercise.controller;

import com.codegym.exercise.entity.Blog;
import com.codegym.exercise.entity.Category;
import com.codegym.exercise.service.blog.IBlogService;
import com.codegym.exercise.service.category.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/blog/api")
@CrossOrigin(origins = "*")
public class BlogCateRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;


    //bài 12

    //1. tìm blog theo keyword:
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findByKeyword(@RequestParam String keyword) {
        List<Blog> blogList = blogService.findByContentContaining(keyword);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    //2. phân trang
    @GetMapping({"/list"})
    public ResponseEntity<Page<Blog>> findAll(@RequestParam int page) {
        Page<Blog> blogList = blogService.findAllPage(PageRequest.of(page,2, Sort.by("createDate").descending()));  //PageRequest.of(a,b): a = page thứ..., b= số phần tử của page
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
