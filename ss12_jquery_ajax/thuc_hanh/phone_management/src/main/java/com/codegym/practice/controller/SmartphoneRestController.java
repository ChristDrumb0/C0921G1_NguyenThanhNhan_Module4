package com.codegym.practice.controller;

import com.codegym.practice.entity.Smartphone;
import com.codegym.practice.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneRestController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Cap nhat object
    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> editById(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        Smartphone smartphoneUpdate = smartphoneService.findById(id).get();

        if (smartphoneUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneUpdate.setModel(smartphone.getModel());
        smartphoneUpdate.setPrice(smartphone.getPrice());
        smartphoneUpdate.setProducer(smartphone.getProducer());

        this.smartphoneService.save(smartphoneUpdate);
        return new ResponseEntity<>(smartphoneUpdate, HttpStatus.OK);
    }

}
