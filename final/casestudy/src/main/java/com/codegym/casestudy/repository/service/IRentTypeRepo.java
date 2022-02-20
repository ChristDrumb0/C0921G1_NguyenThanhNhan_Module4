package com.codegym.casestudy.repository.service;

import com.codegym.casestudy.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepo extends JpaRepository<RentType,Integer> {
}
