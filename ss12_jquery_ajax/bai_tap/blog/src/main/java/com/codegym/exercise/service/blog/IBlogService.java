package com.codegym.exercise.service.blog;

import com.codegym.exercise.entity.Blog;
import com.codegym.exercise.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    //phan trang
    Page<Blog> findAll(Pageable pageable);

    //tim kiem theo title + phan trang
    Page<Blog> findByTitle(String title, Pageable pageable);

    //tim kiem theo category + phan trang
    Page<Blog> findByCategory(Long category_id,Pageable pageable);

    //tim kiem theo title & category + phan trang
    Page<Blog> findBlogByTitleContainingAndCategoryId(String title, Long category_id, Pageable pageable);

    //tim kiem theo category
    List<Blog> findByCategoryId(Long id);

    //bài 12
    Page<Blog> findAllPage(Pageable pageable);

    List<Blog> findByContentContaining(String keyword);
}
