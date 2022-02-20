package com.codegym.casestudy.service.imp.service;

import com.codegym.casestudy.model.entity.service.Services;
import com.codegym.casestudy.repository.service.IServiceRepo;
import com.codegym.casestudy.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImp implements IServiceService {
    @Autowired
    private IServiceRepo iServiceRepo;

    @Override
    public List<Services> findAll() {
        return iServiceRepo.findAll();
    }

    @Override
    public Page<Services> findAllPage(Pageable pageable) {
        return iServiceRepo.findAll(pageable);
    }

    @Override
    public void save(Services object) {
        iServiceRepo.save(object);
    }

    @Override
    public void delete(Long id) {
        iServiceRepo.deleteById(id);
    }

    @Override
    public Optional<Services> findById(Long id) {
        return iServiceRepo.findById(id);
    }
}
