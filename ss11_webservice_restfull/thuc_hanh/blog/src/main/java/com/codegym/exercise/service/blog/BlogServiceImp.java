package com.codegym.exercise.service.blog;

import com.codegym.exercise.entity.Blog;
import com.codegym.exercise.repository.IBlogRepository;
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
    public Iterable<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
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
    public List<Blog> findByCategoryId(Long id) {
        return repository.findByCategory_Id(id);
    }
}
