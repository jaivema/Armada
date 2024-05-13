package com.armada.armadacider.model;

import jakarta.persistence.Id;
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
    private String id;
    private String productName;
    private String characteristics;
    private float price;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        this.getCustomers().add(customer);

    }
}
