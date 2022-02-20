package com.codegym.casestudy.repository.service;

import com.codegym.casestudy.model.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepo extends JpaRepository<ServiceType,Integer> {
}
