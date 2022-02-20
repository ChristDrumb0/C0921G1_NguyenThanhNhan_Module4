package com.codegym.casestudy.service.imp.customer;

import com.codegym.casestudy.model.entity.customer.CustomerType;
import com.codegym.casestudy.repository.customer.ICustomerTypeRepo;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImp implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepo iCustomerTypeRepo;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepo.findAll();
    }
}
