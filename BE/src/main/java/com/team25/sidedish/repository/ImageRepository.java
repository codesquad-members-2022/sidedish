package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Image;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query("SELECT ID, URL FROM IMAGE WHERE PRODUCT_ID = :productId")
    Optional<List<Image>> findImagesByProductId(@Param("productId") Long productId);
}
