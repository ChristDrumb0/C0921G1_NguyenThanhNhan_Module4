package com.codegym.casestudy.service.imp.employee;

import com.codegym.casestudy.model.entity.employee.Position;
import com.codegym.casestudy.repository.employee.IEducationRepo;
import com.codegym.casestudy.repository.employee.IPositionRepo;
import com.codegym.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImp implements IPositionService {

    @Autowired
    private IPositionRepo iPositionRepo;

    @Override
    public List<Position> findAll() {
        return iPositionRepo.findAll();
    }
}
