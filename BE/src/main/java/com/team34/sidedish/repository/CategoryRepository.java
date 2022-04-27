package com.team34.sidedish.repository;

import com.team34.sidedish.domain.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByIsEvent(@Param("isEvent")boolean isEvent);
}
