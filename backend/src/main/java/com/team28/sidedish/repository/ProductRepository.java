package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
