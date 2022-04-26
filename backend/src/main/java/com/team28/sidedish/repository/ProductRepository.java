package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.ProductEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("UPDATE PRODUCT SET STOCK_QUANTITY = :quantity WHERE ID = :productId")
    void updateStockQuantity(
            @Param("productId") Long productId,
            @Param("quantity") int stockQuantity);

}
