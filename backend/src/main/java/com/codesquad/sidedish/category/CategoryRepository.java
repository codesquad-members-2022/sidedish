package com.codesquad.sidedish.category;

import com.codesquad.sidedish.category.domain.Category;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends Repository<Category, Integer> {

    @Query(value = "select sub.* from category sub"
        + " join category sec on sub.section_id = sec.category_id"
        + " where sec.category_name = :section_name")
    List<Category> findBySectionName(@Param("section_name") String sectionName);
}
