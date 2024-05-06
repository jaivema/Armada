package com.armada.armadacider.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    private String id;
    private String name;
    private String characteristics;
    private float price;
}
