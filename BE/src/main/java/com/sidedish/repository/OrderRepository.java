package com.sidedish.repository;

import com.sidedish.domain.User;
import com.sidedish.domain.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<UserOrder, Integer> {

}
