package com.sidedish.repository;

import com.sidedish.domain.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface UserOrderRepository extends CrudRepository<UserOrder, Integer> {

}
