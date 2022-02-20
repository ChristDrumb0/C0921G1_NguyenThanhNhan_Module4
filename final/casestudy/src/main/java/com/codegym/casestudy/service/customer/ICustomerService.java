package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findByKeyword(String name, Integer cusTypeId, Pageable pageable);

    List<Customer> findAll();

    Page<Customer> findAllPage(Pageable pageable);

    void save(Customer object);

    void delete(Long id);

    Optional<Customer> findById(Long id);
}
