package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImp implements IService{

    @Autowired
    IRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
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
