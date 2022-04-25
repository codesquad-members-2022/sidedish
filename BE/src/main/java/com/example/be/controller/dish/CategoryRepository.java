package com.example.be.controller.dish;

import com.example.be.domain.category.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
