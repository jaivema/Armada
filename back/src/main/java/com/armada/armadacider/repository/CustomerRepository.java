package com.armada.armadacider.repository;

import com.armada.armadacider.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, String> {


}
