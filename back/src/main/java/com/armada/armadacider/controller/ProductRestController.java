package com.armada.armadacider.controller;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.ProductRepository;
import com.armada.armadacider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/product/")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/products")
    public Iterable<Product> getAllProducts (){


        return productRepository.findAll();

    }
}
