package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
