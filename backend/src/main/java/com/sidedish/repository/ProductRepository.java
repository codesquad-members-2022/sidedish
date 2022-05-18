package com.sidedish.repository;

import com.sidedish.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager entityManager;

    public Product findOne(Long id){
        return entityManager.find(Product.class, id);
    }

    public List<Product> findMainCategory(String category){
        return entityManager.createQuery("select p from Product p where p.mainCategory = :mainCategory", Product.class)
                .setParameter("mainCategory", category)
                .getResultList();
    }

    public List<Product> findEventCategory(String category){
        return entityManager.createQuery("select p from Product p where p.eventCategory = :category", Product.class)
                .setParameter("category", category)
                .getResultList();
    }
}
