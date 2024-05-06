package com.armada.armadacider.controller;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public ArrayList<Product> getAllProducts (){


        return productService.getAllProducts();

    }
}
