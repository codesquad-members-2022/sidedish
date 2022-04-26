package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.domain.Product;
import com.team28.sidedish.exception.ProductNotFoundException;
import com.team28.sidedish.repository.CategoryRepository;
import com.team28.sidedish.repository.DiscountRepository;
import com.team28.sidedish.repository.ProductRepository;
import com.team28.sidedish.repository.entity.CategoryEntity;
import com.team28.sidedish.repository.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<ProductEntity> findProducts(Long categoryId) {
        Optional<CategoryEntity> categoryFindResult = categoryRepository.findById(categoryId);

        if (categoryFindResult.isEmpty()) {
            return Collections.emptyList();
        }

        CategoryEntity category = categoryFindResult.get();

        return category.getProducts()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public ProductEntity findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }
}
