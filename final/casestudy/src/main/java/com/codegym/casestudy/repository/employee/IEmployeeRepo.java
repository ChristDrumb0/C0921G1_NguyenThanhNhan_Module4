package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Long> {
    @Query("select e From Employee e WHERE concat(e.id,e.name,e.division.name,e.email) LIKE %?1%")
    public Page<Employee> findAll(String keyword, Pageable pageable);

}
