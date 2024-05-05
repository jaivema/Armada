package com.armada.armadacider.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private String direction;
    private String mobile;
    private String email;

}

@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
private List<Product> products = new ArrayList<>();

}

/*public void addProduct(Product product) {
    this.getProducts().add(product);
    //if (simulation.getId() != null) simulation.getId().getSimulations().remove(simulation);
    productsetCustomer(this);
  }*/
