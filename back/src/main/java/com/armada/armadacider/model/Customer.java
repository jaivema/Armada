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
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

   /* @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Detail> details = new ArrayList<>();*/

    public void addProduct(Product product) {
        if (product != null) {
            this.products.add(product);
            if (product.getCustomers() == null) {
                product.setCustomers(new ArrayList<>());
            }
            product.getCustomers().add(this);
        }
    }

    public void addOrder(PurchaseOrder purchaseOrder) {
        if (purchaseOrder != null) {
            this.purchaseOrders.add(purchaseOrder);
            purchaseOrder.setCustomer(this);
        }
    }
    /*public void addDetail(Detail detail) {
        if (detail != null) {
            this.details.add(detail);
            detail.setCustomer(this); // Asigna este cliente al detalle
        }
    }*/
}
