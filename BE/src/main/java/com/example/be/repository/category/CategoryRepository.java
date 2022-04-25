package com.example.be.repository.category;

import com.example.be.domain.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
