package com.team34.sidedish.repository;

import com.team34.sidedish.domain.Category;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query("SELECT * FROM category WHERE is_event = :isEvent")
    public List<Category> findAllByEvent(@Param("isEvent")boolean isEvent);
}
