package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.entity.service.RentType;
import com.codegym.casestudy.repository.service.IRentTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IRenttypeService {

    public List<RentType> findAll();
}
