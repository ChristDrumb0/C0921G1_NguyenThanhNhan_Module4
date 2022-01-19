package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImp implements ICateService{

    @Autowired
    ICategoryRepository cateRepo;

    @Override
    public List<Category> findAll(){
        return cateRepo.findAll();
    }



}
