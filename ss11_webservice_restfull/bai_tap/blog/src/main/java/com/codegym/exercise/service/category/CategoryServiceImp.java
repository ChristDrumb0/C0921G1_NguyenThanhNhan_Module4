package com.codegym.exercise.service.category;

import com.codegym.exercise.entity.Category;
import com.codegym.exercise.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryServiceImp implements ICategoryService{

    @Autowired
    ICategoryRepository repository;

    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
