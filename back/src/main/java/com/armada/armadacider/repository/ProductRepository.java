package com.armada.armadacider.repository;


import com.armada.armadacider.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {}
