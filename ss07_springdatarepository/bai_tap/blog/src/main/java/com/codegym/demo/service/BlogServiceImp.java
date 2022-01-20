package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImp implements IBlogService {

    @Autowired
    IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    //phan trang
    @Override
    public Page<Blog> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    //tim kiem theo Title
    @Override
    public Page<Blog> findByTitle(String title, Pageable pageable){
        return repository.findByTitleContaining(title,pageable);
    }

    //tim kiem theo category
    @Override
    public Page<Blog> findByCategory(Long category_id,Pageable pageable){
        return repository.findBlogByCategory_Id(category_id, pageable);
    }

    //tim kiem theo title & category
    @Override
    public Page<Blog> findBlogByTitleContainingAndCategoryId(String title, Long category_id, Pageable pageable) {
        return repository.findBlogByTitleContainingAndCategory_Id(title, category_id, pageable);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
