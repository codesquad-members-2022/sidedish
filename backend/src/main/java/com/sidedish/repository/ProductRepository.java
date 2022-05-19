package com.sidedish.repository;

import com.sidedish.domain.product.EventCategory;
import com.sidedish.domain.product.MainCategory;
import com.sidedish.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    List<Product> findAllByMainCategory(MainCategory mainCategory);

    List<Product> findAllByEventCategory(EventCategory eventCategory);
}
