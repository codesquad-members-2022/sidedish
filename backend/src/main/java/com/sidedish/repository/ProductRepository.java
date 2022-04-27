package com.sidedish.repository;

import com.sidedish.domain.product.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select * from product where main_category= :categoryName")
    List<Product> findAllMainCategoryProduct(@Param("categoryName") String category);

    @Query("select * from product where event_category= :categoryName order by rand() limit 3")
    List<Product> findAllEventCategoryProduct(@Param("categoryName") String category);

    @Query("select * from product where id= :id")
    Optional<Product> findById(@Param("id") Long id);
}
