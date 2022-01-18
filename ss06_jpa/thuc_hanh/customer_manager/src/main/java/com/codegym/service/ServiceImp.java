package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImp implements IService{
    @Autowired
    public IRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.remove(id);
    }
}
