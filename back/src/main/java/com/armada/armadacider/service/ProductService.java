package com.armada.armadacider.service;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.ProductRepository;
import com.github.javafaker.Faker;
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

    public Iterable<Product> getAllProducts (){

        return  productRepository.findAll();
    }


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            productRepository.save(
                    new Product ( uniqueID,
                            date.toString(),
                            faker.artist().name(), // For characteristics
                            (float) faker.number().randomDouble(2,10, 1550) // For price
                    )
            );
        }

    }

}
