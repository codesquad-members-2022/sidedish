package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT ID, NAME, PRICE, DESCRIPTION, STOCK "
        + " FROM PRODUCT "
        + " WHERE CATEGORY_ID = :categoryId")
    Optional<List<Product>> findProductsByCategoryId(@Param("categoryId") Long categoryId);
}
