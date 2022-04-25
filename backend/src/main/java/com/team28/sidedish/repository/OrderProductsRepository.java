package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.OrderProductsEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductsRepository extends CrudRepository<OrderProductsEntity, Long> {

}
