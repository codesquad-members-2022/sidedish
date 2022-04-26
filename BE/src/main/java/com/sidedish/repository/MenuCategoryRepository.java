package com.sidedish.repository;

import com.sidedish.domain.MenuCategory;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MenuCategoryRepository extends CrudRepository<MenuCategory, Integer> {

    @Query("SELECT id, name FROM menu_category LIMIT 1")
    MenuCategory findFirstMenuCategory();

    @Query("SELECT id, name FROM menu_category LIMIT 1, 18446744073709551615")
    List<MenuCategory> findRestOfMenuCategories();
}
