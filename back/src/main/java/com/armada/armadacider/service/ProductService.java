package com.armada.armadacider.service;

import com.armada.armadacider.model.Product;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.Locale;

@Service
public class ProductService {
    static ArrayList<Product> products = new ArrayList<>();

    // we will fill the list products
    // with fake objects product
    // we need the faker dependency
    // and then the loop will create and add one-by-one
    static {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            products.add(
                    new Product ( uniqueID,
                            date.toString(),
                            faker.artist().name(), // For characteristics
                            (float) faker.number().randomDouble(2,10, 1550) // For price
                    )
            );
        }

    }

    // return products to controller
    // get products form list static from class and return as signature
    public ArrayList<Product> getAllProducts (){
        return products;
    }


}
