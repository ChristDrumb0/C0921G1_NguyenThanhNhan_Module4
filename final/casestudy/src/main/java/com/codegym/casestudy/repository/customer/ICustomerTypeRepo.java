package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepo extends JpaRepository<CustomerType,Integer> {
}
