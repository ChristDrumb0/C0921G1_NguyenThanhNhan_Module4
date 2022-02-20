package com.codegym.casestudy.service.imp.employee;

import com.codegym.casestudy.model.entity.employee.Division;
import com.codegym.casestudy.repository.employee.IDivisionRepo;
import com.codegym.casestudy.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;
@Service
public class DivisionServiceImp implements IDivisionService {

    @Autowired
    private IDivisionRepo repository;

    @Override
    public List<Division> findAll() {
        return repository.findAll();
    }



}
