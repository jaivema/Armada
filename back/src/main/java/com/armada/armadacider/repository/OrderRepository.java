package com.armada.armadacider.repository;

import com.armada.armadacider.model.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<PurchaseOrder, String> {
}
