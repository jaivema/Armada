package com.armada.armadacider.service;

import com.armada.armadacider.model.PurchaseOrder;
import com.armada.armadacider.repository.OrderRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<PurchaseOrder> createFakeOrders() {
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setId(uniqueID);
            purchaseOrder.setDate(date);
            purchaseOrder.setDetailId(purchaseOrder.getDetailId());
            purchaseOrders.add(purchaseOrder);
        }
        return purchaseOrders;
    }
    public List<PurchaseOrder> populate() {

        List<PurchaseOrder> purchaseOrders = createFakeOrders();

        for (int i = 0; i <10 ; i++ ){
            orderRepository.save(purchaseOrders.get(i));
            purchaseOrders.add(purchaseOrders.get(i));
        }

        return purchaseOrders;
    }

}

