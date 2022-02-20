package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepo extends JpaRepository<Position,Long> {
}
