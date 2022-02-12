package com.codegym.exercise.controller;

import com.codegym.exercise.entity.Blog;
import com.codegym.exercise.entity.Category;
import com.codegym.exercise.service.blog.IBlogService;
import com.codegym.exercise.service.category.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/blog")
public class BlogCateRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    //xem danh sach category
    @GetMapping("/category_list")
    public ResponseEntity<Iterable<Category>> showListCategory () {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    //Xem danh sách các bài viết
    @GetMapping("/blog_list")
    public ResponseEntity<Iterable<Blog>> showListBlog(){
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    //xem danh sach bai viet mot Category
    @GetMapping("/category_list/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategoryId(@PathVariable Long id) {
        List<Blog> blogList = blogService.findByCategoryId(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    //Xem chi tiết một bài viết
    @GetMapping("/blog_list/{id}")
    public ResponseEntity<List<Blog>> findBlogById(@PathVariable Long id) {
        Optional<Blog> blogList = blogService.findById(id);

        if (!blogList.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList.map(Collections::singletonList)
                .orElseGet(Collections::emptyList),HttpStatus.OK);
    }
}
