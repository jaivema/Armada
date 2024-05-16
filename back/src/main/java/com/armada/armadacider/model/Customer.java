package com.armada.armadacider.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;

    @JsonIgnore
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Customer_Product_FKS",
            joinColumns =  @JoinColumn(name = "Customer_FKS") ,
            inverseJoinColumns =  @JoinColumn(name = "Product_FKS") )
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PurcharseOrder> purcharseOrders = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
        product.getCustomers().add(this);
    }
    public void addOrder (PurcharseOrder purcharseOrder) {
        this.getPurcharseOrders().add(purcharseOrder);
        //if (order.getId() != null) order.getId().getOrders().remove(order);
        purcharseOrder.setCustomer(this);
    }
}
