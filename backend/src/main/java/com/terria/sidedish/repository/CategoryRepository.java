package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByExhibitionId(long exhibitionId);
}
