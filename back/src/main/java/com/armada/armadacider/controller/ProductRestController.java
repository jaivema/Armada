package com.armada.armadacider.controller;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.ProductRepository;
import com.armada.armadacider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/products/")
public class ProductRestController {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping ("/products")
    public Iterable<Product> getAllProducts (){
        return productRepository.findAll();

    }
    @PostMapping("/populate")
    public String populateDB(){

        productService.populate();

        return "ok";
    }
}
