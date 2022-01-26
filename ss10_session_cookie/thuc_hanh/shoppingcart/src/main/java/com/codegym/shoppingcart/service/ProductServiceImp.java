package com.codegym.shoppingcart.service;

import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private IProductRepository repository;


    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
