package com.example.be.business.category.repository;

import com.example.be.business.category.domain.Category;
import com.example.be.business.dish.service.DishInformationResponse;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    // 최악
    @Query("SELECT dish.dish_id, dish.name, dish.description, dish.category_id, dish.price, dish.badge, dish.thumbnail, category.category_type, category.description AS category_description, sub_category.description_detail FROM dish JOIN category ON category.category_id = dish.category_id JOIN sub_category ON sub_category.category_id = category.category_id")
    List<DishInformationResponse> getDishesByCategory();
}
