package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByExhibitionId(long exhibitionId);
}
