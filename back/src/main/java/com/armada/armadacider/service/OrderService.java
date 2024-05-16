package com.armada.armadacider.service;

import com.armada.armadacider.model.PurcharseOrder;
import com.armada.armadacider.repository.OrderRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<PurcharseOrder> createFakeOrders() {
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<PurcharseOrder> purcharseOrders = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            PurcharseOrder purcharseOrder = new PurcharseOrder();
            purcharseOrder.setId(uniqueID);
            purcharseOrder.setDate(date);
            purcharseOrder.setCustomerId(faker.idNumber().toString());
            purcharseOrder.setDetailId(faker.idNumber().toString());
            purcharseOrders.add(purcharseOrder);
        }
        return purcharseOrders;
    }
    public List<PurcharseOrder> populate() {

        List<PurcharseOrder> purcharseOrders = createFakeOrders();

        for (int i = 0; i <10 ; i++ ){
            orderRepository.save(purcharseOrders.get(i));
            purcharseOrders.add(purcharseOrders.get(i));
        }

        return purcharseOrders;
    }

}

