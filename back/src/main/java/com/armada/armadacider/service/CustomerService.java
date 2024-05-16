package com.armada.armadacider.service;

import com.armada.armadacider.model.Customer;
import com.armada.armadacider.model.PurcharseOrder;
import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.CustomerRepository;
import com.armada.armadacider.repository.OrderRepository;
import com.armada.armadacider.repository.ProductRepository;
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
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    public List<Customer> createFakeCustomers() {


        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));

        List<Customer> customers = new ArrayList<>();
        //Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {
            uniqueID = UUID.randomUUID().toString();
            Customer customer = new Customer();
            customer.setId(uniqueID);
            customer.setName(faker.artist().name());
            customer.setSurname(faker.artist().name());
            customer.setAddress(faker.address().fullAddress());
            customer.setEmail(faker.internet().emailAddress());
            customer.setPhoneNumber(faker.phoneNumber().phoneNumber());
            customers.add(customer);
        }
        return customers;
    }
        public List<Customer> populate() {

            List<Customer> customers = createFakeCustomers();

            List<Product> products = productService.createFakeProducts();

            List<PurcharseOrder> purcharseOrders = orderService.createFakeOrders();

// Guardar todos los clientes en la base de datos
            for (Customer c: customers) {
                customerRepository.save(c);
                for (Product pro : products) {
                    productRepository.save(pro);
                    c.addProduct(pro);
                    customerRepository.save(c);
                }
                for (PurcharseOrder ord : purcharseOrders) {
                    orderRepository.save(ord);
                    c.addOrder(ord);
                    customerRepository.save(c);
                }
            }
                return customers;
        }
}
