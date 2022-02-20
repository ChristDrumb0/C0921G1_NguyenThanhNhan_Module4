package com.codegym.casestudy.service.imp.service;

import com.codegym.casestudy.model.entity.service.RentType;
import com.codegym.casestudy.repository.service.IRentTypeRepo;
import com.codegym.casestudy.service.service.IRenttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImp implements IRenttypeService {
    @Autowired
    private IRentTypeRepo iRentTypeRepo;


    @Override
    public List<RentType> findAll() {
        return iRentTypeRepo.findAll();
    }
}
