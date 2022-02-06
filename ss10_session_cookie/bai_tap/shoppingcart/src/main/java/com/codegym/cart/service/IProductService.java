package com.codegym.cart.service;

import com.codegym.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService  {
    Optional<Product> finById(Long id);

    List<Product> findAll();
}
