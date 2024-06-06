package com.armada.armadacider.service;

import com.armada.armadacider.model.Detail;
import com.armada.armadacider.model.Product;
import com.armada.armadacider.model.PurchaseOrder;
import com.armada.armadacider.repository.DetailRepository;
import com.armada.armadacider.repository.OrderRepository;
import com.armada.armadacider.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DetailService {

    @Autowired
    DetailRepository detailRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Detail> createFakeDetails() {
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<Detail> details = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            double precioDouble = faker.number().randomDouble(2, 0, 1000);
            float precioFloat = (float) precioDouble;
            float precioTotal = (float) precioDouble;

            // Obtener o crear un producto de ejemplo
            String productId = UUID.randomUUID().toString();
            Product product = new Product();
            product.setProductId(productId);
            productRepository.save(product);

            // Obtener o crear una orden de compra de ejemplo
            String purchaseOrderId = UUID.randomUUID().toString();
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setPurchaseOrderId(purchaseOrderId);
            orderRepository.save(purchaseOrder);

            Detail detail = new Detail();
            detail.setDetailId(uniqueID);
            detail.setDate(date);
            detail.setProductName(faker.artist().name());
            detail.setQuantity(faker.number().numberBetween(0, 500));
            detail.setPrice(precioFloat);
            detail.setDiscount(faker.number().randomDigit());
            detail.setTaxes(faker.number().numberBetween(0, 100));
            detail.setTotal(precioTotal);
            detail.setPaid(false);
            detail.setProduct(product);
            detail.setPurchaseOrder(purchaseOrder);

            details.add(detail); // Agregar el detalle creado a la lista
        }
        return details;
    }
    public List<Detail> populate() {

        List<Detail> details = createFakeDetails();

        // Guardar los detalles en la base de datos
        for (Detail detail : details) {
            detailRepository.save(detail);
        }
        return details;
    }
}
