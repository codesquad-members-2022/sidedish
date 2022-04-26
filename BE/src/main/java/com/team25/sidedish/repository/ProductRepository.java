package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT ID, NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK "
        + " FROM product "
        + " WHERE CATEGORY_ID = :categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);

    @Override
    Optional<Product> findById(Long productId);

    @Override
    Product save(Product product);
}
