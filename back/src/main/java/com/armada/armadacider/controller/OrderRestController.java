package com.armada.armadacider.controller;

import com.armada.armadacider.model.PurchaseOrder;
import com.armada.armadacider.repository.CustomerRepository;
import com.armada.armadacider.repository.OrderRepository;
import com.armada.armadacider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/'order'/")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    //CRUD: read
    @RequestMapping("/'order'")
    public Iterable<PurchaseOrder> getAllOrders() {

        return orderRepository.findAll();

    }

    //CRUD: delete
    @DeleteMapping("/delete")
    public String deleteOrder(@RequestParam String id) {

        //System.out.println("id:" + id);
        Optional<PurchaseOrder> orderFound = orderRepository.findById(id);
        long countBefore = orderRepository.count();
        //System.out.println("orderFound:" + orderFound);

        if (orderFound.isPresent()) {
            orderRepository.deleteById(id);
            long countAfter = orderRepository.count();
            String response = "order deleted: " + id + " count: " + countBefore + "/" + countAfter;
            return response;
        } else return "id: " + id + " not found " + " count: " + countBefore;

    }

    //CRUD: create
    @PostMapping(path = "create", consumes = "application/JSON")
    public PurchaseOrder createOrder(@RequestBody PurchaseOrder purchaseOrder) {
        //
        PurchaseOrder purchaseOrderCreated = orderRepository.save(purchaseOrder);
        return purchaseOrderCreated;
    }

    //CRUD: update
   @PutMapping("/update/{id}")
    public PurchaseOrder updateOrder(@PathVariable String id, @RequestBody PurchaseOrder purchaseOrder) {
        // Verificar si la orden con el ID proporcionado existe en la base de datos
        Optional<PurchaseOrder> orderFound = orderRepository.findById(id);

        if (orderFound.isPresent()) {
            PurchaseOrder purchaseOrderToUpdate = orderFound.get();
            // Actualizar los campos de la orden existente con los valores proporcionados en la orden actualizada
            purchaseOrderToUpdate.setDate(purchaseOrder.getDate());
            purchaseOrderToUpdate.setDetailId(purchaseOrder.getDetailId());

        // Guardar la orden actualizada en la base de datos
        PurchaseOrder purchaseOrderUpdated = orderRepository.save(purchaseOrderToUpdate);
        return purchaseOrderToUpdate;
    } else {
            // Devolver un mensaje de error con código de estado 404 Not Found
            return null;
        }

}
    @RequestMapping("/populate")
    public String populateOrderDB() {

        orderService.populate();

        return "ok";
    }
}


