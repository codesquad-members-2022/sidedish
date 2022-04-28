package com.sidedish.repository;

import com.sidedish.domain.MenuCategory;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuCategoryRepository extends CrudRepository<MenuCategory, Integer> {

    @Query("SELECT id, name FROM menu_category LIMIT 1")
    MenuCategory findFirstMenuCategory();

    @Query("SELECT id, name FROM menu_category LIMIT 1, 3")
    List<MenuCategory> findRestOfMenuCategories();
}
