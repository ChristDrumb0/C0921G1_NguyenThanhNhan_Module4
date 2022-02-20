package com.codegym.casestudy.service.imp.service;

import com.codegym.casestudy.model.entity.service.ServiceType;
import com.codegym.casestudy.repository.service.IServiceRepo;
import com.codegym.casestudy.repository.service.IServiceTypeRepo;
import com.codegym.casestudy.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImp implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepo iServiceTypeRepo;


    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepo.findAll();
    }
}
