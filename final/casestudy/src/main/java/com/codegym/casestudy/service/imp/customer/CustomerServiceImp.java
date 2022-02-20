package com.codegym.casestudy.service.imp.customer;

import com.codegym.casestudy.model.entity.customer.Customer;
import com.codegym.casestudy.repository.customer.ICustomerRepo;
import com.codegym.casestudy.service.customer.ICustomerService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public Page<Customer> findByKeyword(String name, Integer cusTypeId, Pageable pageable) {
        return iCustomerRepo.findAll(name,cusTypeId,pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Page<Customer> findAllPage(Pageable pageable) {
        return iCustomerRepo.findAll(pageable);
    }

    @Override
    public void save(Customer object) {
        iCustomerRepo.save(object);
    }

    @Override
    public void delete(Long id) {
        iCustomerRepo.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepo.findById(id);
    }
}
