package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Long> {
}
