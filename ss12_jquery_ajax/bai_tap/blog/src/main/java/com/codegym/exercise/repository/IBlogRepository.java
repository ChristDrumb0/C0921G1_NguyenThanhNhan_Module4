package com.codegym.exercise.repository;

import com.codegym.exercise.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Page<Blog> findBlogByCategory_Id(Long category_id, Pageable pageable);

    Page<Blog> findBlogByTitleContainingAndCategory_Id(String title, Long category_id, Pageable pageable);

    List<Blog> findByCategory_Id(Long id);

    //bài 12
    List<Blog> findByContentContaining(String keyword);
}
