package com.codegym.cart.service;

import com.codegym.cart.model.Product;
import com.codegym.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Optional<Product> finById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
