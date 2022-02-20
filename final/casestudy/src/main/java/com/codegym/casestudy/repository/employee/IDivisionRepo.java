package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepo extends JpaRepository<Division,Long> {
}
