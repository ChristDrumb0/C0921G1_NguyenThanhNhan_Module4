package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();
}
