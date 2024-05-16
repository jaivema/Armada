package com.armada.armadacider.repository;

import com.armada.armadacider.model.PurcharseOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<PurcharseOrder, String> {
}
