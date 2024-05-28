package com.armada.armadacider.service;

import com.armada.armadacider.model.Customer;
import com.armada.armadacider.model.Detail;
import com.armada.armadacider.model.PurchaseOrder;
import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.CustomerRepository;
import com.armada.armadacider.repository.DetailRepository;
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
    @Autowired
    DetailService detailService;
    @Autowired
    DetailRepository detailRepository;

    public List<Customer> createFakeCustomers() {


        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        List<Customer> customers = new ArrayList<>();
        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {
            uniqueID = UUID.randomUUID().toString();

            // Obtener o crear una orden de compra de ejemplo
            /*String purchaseOrderId = UUID.randomUUID().toString();
            PurchaseOrder purchaseOrders = new PurchaseOrder();
            purchaseOrders.setPurchaseOrderId(purchaseOrderId);
            orderRepository.save(purchaseOrders);*/

            Customer customer = new Customer();
            customer.setId(uniqueID);
            customer.setName(faker.artist().name());
            customer.setSurname(faker.artist().name());
            customer.setAddress(faker.address().fullAddress());
            customer.setEmail(faker.internet().emailAddress());
            customer.setPhoneNumber(faker.phoneNumber().phoneNumber());
            //customer.setPurchaseOrders(new ArrayList<>());
            customers.add(customer);
        }
        return customers;
    }
        public List<Customer> populate() {

            List<Customer> customers = createFakeCustomers();
            List<Product> products = productService.createFakeProducts();
            List<PurchaseOrder> purchaseOrders = orderService.createFakeOrders();
            //List<Detail> details = detailService.createFakeDetails(); // Asumiendo que tienes un método para crear detalles falsos

// Guardar todos los clientes en la base de datos
            for (Customer c: customers) {
                for (Product pro : products) {
                    c.addProduct(pro);
                }
                for (PurchaseOrder ord : purchaseOrders) {
                    c.addOrder(ord);
                }
                /*for (Detail det : details) {
                    // Suponiendo que tienes un método `addDetail` en `Customer` o que `Detail` está relacionado con `Customer`
                    det.setCustomer(c); // Si Detail tiene una referencia a Customer
                    c.getDetails().add(det); // Agregar detalle a la lista de detalles del cliente, si existe
                }*/
                customerRepository.save(c);
            }

            // Guardar productos y órdenes después de agregar a los clientes
            productRepository.saveAll(products);
            orderRepository.saveAll(purchaseOrders);
            //detailRepository.saveAll(details);

                return customers;
        }
}
