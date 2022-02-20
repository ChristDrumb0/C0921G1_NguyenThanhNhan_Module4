package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    List<Services> findAll();

    Page<Services> findAllPage(Pageable pageable);

    void save(Services object);

    void delete(Long id);

    Optional<Services> findById(Long id);

}
