package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IService {

    List<Blog> findAll();
    void save(Blog blog);
    Optional<Blog> findById(int id);
    void delete(Integer id);
}
