package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmlpoyeeService {

    List<Employee> findAll();

    Page<Employee> findAllPage(String keyword, Pageable pageable);

    void save(Employee object);

    void delete(Long id);

    Optional<Employee> findById(Long id);
}
