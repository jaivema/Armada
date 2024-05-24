package com.armada.armadacider.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    private String productId;
    private String productName; // Actualizable
    private String characteristics; // Actualizable
    private float price; // Actualizable


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Detail> details = new ArrayList<>();

    public void addCustomer(Customer customer) {
        if (customer != null) {
            this.customers.add(customer);
            if (customer.getProducts() == null) {
                customer.setProducts(new ArrayList<>());
            }
            customer.getProducts().add(this);
        }
    }

    public void addDetail(Detail detail) {
        if (detail != null) {
            this.details.add(detail);
            detail.setProduct(this); // Asigna este producto al detalle
        }
    }
}
