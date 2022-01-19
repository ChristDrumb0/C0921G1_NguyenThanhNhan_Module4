package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Page<Blog> findBlogByCategory_Id(Long category_id, Pageable pageable);

    Page<Blog> findBlogByTitleContainingAndCategory_Id(String title, Long category_id, Pageable pageable);

}
