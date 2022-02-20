package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.entity.employee.Position;

import java.util.List;

public interface IPositionService {

    List<Position> findAll();
}
