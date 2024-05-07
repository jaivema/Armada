package com.armada.armadacider.service;

import com.armada.armadacider.model.Customer;
import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductService productService;


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));

        List<Product> products = new ArrayList<>();
        //Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            products = productService.populate();
            uniqueID = UUID.randomUUID().toString();
            String phoneNumber = faker.phoneNumber().phoneNumber();
            String address = faker.address().fullAddress();
            Customer customer = new Customer( uniqueID,
            faker.artist().name(),
                    faker.artist().name(),
                    address,
                    phoneNumber,
                    faker.internet().emailAddress(), products );



// Guardar todos los clientes en la base de datos
        Customer save = customerRepository.save(customer);


    }
    }
}
