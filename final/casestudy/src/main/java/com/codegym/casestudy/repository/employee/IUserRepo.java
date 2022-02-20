package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.entity.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,String> {

    User findByUserName(String username);

}
