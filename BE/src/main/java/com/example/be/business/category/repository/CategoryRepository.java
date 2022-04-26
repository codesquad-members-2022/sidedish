package com.example.be.business.category.repository;

import com.example.be.business.category.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
