package com.armada.armadacider.controller;


import com.armada.armadacider.model.Customer;
import com.armada.armadacider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/customers")


public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;


    //CRUD: read
    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers (){


        return customerRepository.findAll();

    }
}
