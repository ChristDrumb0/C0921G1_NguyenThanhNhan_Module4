package com.codegym.casestudy.service.imp.employee;

import com.codegym.casestudy.model.entity.employee.Employee;
import com.codegym.casestudy.repository.employee.IEmployeeRepo;
import com.codegym.casestudy.service.employee.IEmlpoyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements IEmlpoyeeService {
    @Autowired
    private IEmployeeRepo iEmployeeRepo;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public Page<Employee> findAllPage(String keyword, Pageable pageable) {
        if (keyword == null) {
            return iEmployeeRepo.findAll(pageable);
        }
        return iEmployeeRepo.findAll(keyword, pageable);
    }

    @Override
    public void save(Employee object) {
        iEmployeeRepo.save(object);
    }

    @Override
    public void delete(Long id) {
        iEmployeeRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return iEmployeeRepo.findById(id);
    }
}
