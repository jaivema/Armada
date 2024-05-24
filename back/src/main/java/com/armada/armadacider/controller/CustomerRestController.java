package com.armada.armadacider.controller;


import com.armada.armadacider.model.Customer;
import com.armada.armadacider.repository.CustomerRepository;
import com.armada.armadacider.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    //CRUD: read
    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers (){
        return customerRepository.findAll();
    }
    // CRUD: Create
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    // CRUD: Read (single customer by ID)
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id);
    }
    // CRUD: Update
    @PutMapping("/update/{id}")
    public String updateCustomer(@PathVariable String id, @RequestBody Customer newCustomerData) {
        Optional<Customer> customerFound = customerRepository.findById(id);

        if (customerFound.isPresent()) {
            Customer customerToUpdate = customerFound.get();
            customerToUpdate.setName(newCustomerData.getName());
            customerToUpdate.setSurname(newCustomerData.getSurname());
            customerToUpdate.setEmail(newCustomerData.getEmail());
            customerToUpdate.setPhoneNumber(newCustomerData.getPhoneNumber());
            customerToUpdate.setAddress(newCustomerData.getAddress());
            customerRepository.save(customerToUpdate);
            return "Customer updated: " + id;
        } else {
            return "ID: " + id + " not found.";
        }
    }

    // CRUD: Delete
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        Optional<Customer> customerFound = customerRepository.findById(id);
        long countBefore = customerRepository.count();

        if (customerFound.isPresent()) {
            customerRepository.deleteById(id);
            long countAfter = customerRepository.count();
            return "Customer deleted: " + id + " count: " + countBefore + "/" + countAfter;
        } else {
            return "ID: " + id + " not found. Count: " + countBefore;
        }
    }
    @PostMapping("/populate")
    public String populateDB(){

        customerService.populate();

        return "ok";
    }
}
