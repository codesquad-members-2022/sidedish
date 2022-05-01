package com.example.be.business.dish.repository;

import com.example.be.business.dish.domain.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DishRepository extends CrudRepository<Dish, Long> {

}
