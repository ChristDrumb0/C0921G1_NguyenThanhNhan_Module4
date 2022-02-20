package com.codegym.casestudy.repository.service;

import com.codegym.casestudy.model.entity.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepo extends JpaRepository<Services,Long> {

}
