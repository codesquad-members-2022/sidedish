package com.team34.sidedish.repository;

import com.team34.sidedish.domain.Dish;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {

    List<Dish> findAll();
}
