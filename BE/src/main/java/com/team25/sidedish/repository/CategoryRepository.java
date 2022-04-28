package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    List<Category> findAll();
}
