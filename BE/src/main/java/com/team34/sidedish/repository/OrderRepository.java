package com.team34.sidedish.repository;

import com.team34.sidedish.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
