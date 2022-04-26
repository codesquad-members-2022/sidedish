package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    List<CategoryEntity> findAll();
}
