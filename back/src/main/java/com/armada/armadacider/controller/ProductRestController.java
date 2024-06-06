package com.armada.armadacider.controller;

import com.armada.armadacider.model.Product;
import com.armada.armadacider.repository.ProductRepository;
import com.armada.armadacider.service.ProductService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/products/")
public class ProductRestController {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    //CRUD: read
    @GetMapping ("/products")
    public Iterable<Product> getAllProducts (){
        return productRepository.findAll();

    }
    //CRUD: delete
    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam String id) {

        //System.out.println("id:" + id);
        Optional<Product> productFound = productRepository.findById(id);
        long countBefore = productRepository.count();
        //System.out.println("productFound:" + productFound);

        if (productFound.isPresent()){
            productRepository.deleteById(id);
            long countAfter = productRepository.count();
            String response = "product deleted: " + id + " count: " + countBefore + "/" + countAfter;
            return response;
        } else return "id: " + id +  " not found " + " count: " + countBefore;

    }
    //CRUD: create
    @PostMapping(path="create", consumes = "application/JSON")
    public Product createProduct(@RequestBody Product product){
        //
        Product productCreated = productRepository.save(product);
        return productCreated;
    }
    // CRUD: update
    @PutMapping("/update/{id}")
    public String updateProduct(@RequestParam String id, @RequestBody Product newProductData) {
        Optional<Product> productFound = productRepository.findById(id);

        if (productFound.isPresent()) {
            Product productToUpdate = productFound.get();
            productToUpdate.setProductName(newProductData.getProductName());
            productToUpdate.setCharacteristics(newProductData.getCharacteristics());
            productToUpdate.setPrice(newProductData.getPrice());
            productRepository.save(productToUpdate);
            return "Product updated: " + id;
        } else {
            return "ID: " + id + " not found.";
        }
    }

    @PostMapping("/populate")
    public String populateDB(){

        productService.populate();

        return "ok";
    }
}
