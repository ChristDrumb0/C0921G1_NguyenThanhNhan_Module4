package com.codegym.practice.controller;


import com.codegym.practice.entity.Customer;
import com.codegym.practice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    //Read all
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer () {
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
       return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    //Read 1
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    //Create
    @PostMapping
    public ResponseEntity createCustomer (@RequestBody Customer customer) {  //@RequestBody --> function?
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Update
    @PutMapping("/{id}") //update theo id

    public ResponseEntity<Customer> editCustomer (@PathVariable Long id,
                                        @RequestBody Customer customer) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Customer currentCustomer = customerOptional.get();
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());

        customerService.save(currentCustomer);

        return new ResponseEntity<>(currentCustomer,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}") //delete theo id

    public ResponseEntity deleteCustomer (@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        customerService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
