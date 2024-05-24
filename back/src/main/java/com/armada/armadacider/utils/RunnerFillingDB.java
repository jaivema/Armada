package com.armada.armadacider.utils;

import com.armada.armadacider.service.CustomerService;
import com.armada.armadacider.service.DetailService;
import com.armada.armadacider.service.OrderService;
import com.armada.armadacider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class RunnerFillingDB implements ApplicationRunner {

   @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @Autowired
    DetailService detailService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

       productService.populate ();
       customerService.populate();
       orderService.populate();
       detailService.populate();

       }
    }
