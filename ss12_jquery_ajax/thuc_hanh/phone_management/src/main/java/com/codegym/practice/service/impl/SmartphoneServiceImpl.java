package com.codegym.practice.service.impl;

import com.codegym.practice.entity.Smartphone;
import com.codegym.practice.repository.ISmartphoneRepository;
import com.codegym.practice.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneServiceImpl implements ISmartphoneService {
    @Autowired
    ISmartphoneRepository smartphoneRepository;


    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}