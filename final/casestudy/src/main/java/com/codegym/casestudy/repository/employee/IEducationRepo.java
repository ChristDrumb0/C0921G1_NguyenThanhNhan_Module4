package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.entity.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepo extends JpaRepository<Education,Long> {
}
