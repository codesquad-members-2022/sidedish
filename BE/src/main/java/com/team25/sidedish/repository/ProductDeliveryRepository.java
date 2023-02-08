package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Delivery;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDeliveryRepository extends CrudRepository<Delivery, Long> {

    @Query("SELECT D.ID, D.REGION, D.TYPE "
            + "FROM delivery AS D"
            + " JOIN"
            + " ("
            + "     SELECT DELIVERY_ID"
            + "     FROM product_delivery"
            + "     WHERE PRODUCT_ID = :productId"
            + " )"
            + " AS R ON D.ID = R.DELIVERY_ID")
    List<Delivery> findDeliveriesByProductId(@Param("productId") Long productId);
}
