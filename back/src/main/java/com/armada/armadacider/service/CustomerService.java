package com.armada.armadacider.service;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        List<Product> products;
        //Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        List<Customer> customers; // Lista para almacenar los clientes generados

        for (int i = 0; i < 10; i++) {
            uniqueID = UUID.randomUUID().toString();
            Customer customer = new Customer();
            customer.setId(uniqueID);
            customer.setName(faker.artist().name());
            customer.setSurname("Surname"); // Puedes reemplazar con un valor generado aleatoriamente si lo deseas
            customer.setDirection("Dirección"); // Puedes reemplazar con un valor generado aleatoriamente si lo deseas
            customer.setMobile("Mobile"); // Puedes reemplazar con un valor generado aleatoriamente si lo deseas
            customer.setEmail("Email"); // Puedes reemplazar con un valor generado aleatoriamente si lo deseas
            customers.add(customer); // Agregar el cliente a la lista
        }

// Guardar todos los clientes en la base de datos
        customerRepository.saveAll(customers);


    }
    }
}
