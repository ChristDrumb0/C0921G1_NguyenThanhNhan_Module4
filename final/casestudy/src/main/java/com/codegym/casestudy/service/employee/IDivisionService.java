package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.entity.employee.Division;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
}
