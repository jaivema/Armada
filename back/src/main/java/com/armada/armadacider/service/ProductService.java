package com.armada.armadacider.service;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    //static ArrayList<Product> products = new ArrayList<>();

    // we will fill the list products
    // with fake objects product
    // we need the faker dependency
    // and then the loop will create and add one-by-one
    @Autowired
    ProductRepository productRepository;


    public List<Product> createFakeProducts() {


        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        // Date date = new Date();

        List<Product> products = new ArrayList<>();
        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            float price = (float) faker.number().randomDouble(2, 0, 1550);
            Product product = new Product (
                    uniqueID,
                    faker.artist().name(),
                    "Sabor manzana",
                    (float) faker.number().randomDouble(2, 0, 1550), null, null
            );
                    //product.setName(faker.artist().name());
                    products.add(product);
        }
        return products;
    }
    public List<Product> populate() {
        List<Product> products = createFakeProducts();
        int qtyProducts = products.size();


        for (int i = 0; i < qtyProducts ; i++ ){

            productRepository.save(products.get(i));

        }

        return products;
    }
}
