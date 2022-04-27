package com.example.be.repository.dish;

import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.domain.dish.Dish;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {

    @Query("SELECT dish.*, category.* FROM dish JOIN category ON dish.category_id = category.category_id")
    List<PlanningDataRequest> getPlanningData();
}
