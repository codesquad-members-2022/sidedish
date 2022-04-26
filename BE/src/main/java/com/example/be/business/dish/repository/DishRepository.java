package com.example.be.business.dish.repository;

import com.example.be.business.dish.domain.Dish;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {

}
