package com.codegym.casestudy.service.imp.employee;

import com.codegym.casestudy.model.entity.employee.Education;
import com.codegym.casestudy.repository.employee.IEducationRepo;
import com.codegym.casestudy.service.employee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImp implements IEducationService {
    @Autowired
    private IEducationRepo iEducationRepo;

    @Override
    public List<Education> findAll() {
        return iEducationRepo.findAll();
    }
}
