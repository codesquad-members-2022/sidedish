package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {

}
