package com.armada.armadacider.model;


import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import jakarta.persistence.CascadeType;
import javax.persistence.Entity;
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


@OneToMany (mappedBy = "id", cascade = CascadeType.ALL)
private List<Product> products = new ArrayList<>();

}

/*public void addProduct(Product product) {
    this.getProducts().add(product);
    //if (simulation.getId() != null) simulation.getId().getSimulations().remove(simulation);
    productsetCustomer(this);
  }*/
