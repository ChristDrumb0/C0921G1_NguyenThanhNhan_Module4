package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    //phan trang
    Page<Blog> findAll(Pageable pageable);

    //tim kiem theo title
    Page<Blog> findByTitle(String title, Pageable pageable);

    //tim kiem theo category
    Page<Blog> findByCategory(Long category_id,Pageable pageable);

    //tim kiem theo title & category
    Page<Blog> findBlogByTitleContainingAndCategoryId(String title, Long category_id, Pageable pageable);


    void save(Blog blog);
    Optional<Blog> findById(int id);
    void delete(Integer id);
}
