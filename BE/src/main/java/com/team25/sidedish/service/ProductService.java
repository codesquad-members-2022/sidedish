package com.team25.sidedish.service;

import com.team25.sidedish.domain.Product;
import com.team25.sidedish.exception.ProductNotExistException;
import com.team25.sidedish.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> getProductsByCategoryId(Long categoryId) {
        categoryService.validCategoryExist(categoryId);
        return productRepository.findProductsByCategoryId(categoryId);
    }

    public Product getProductByProductId(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(ProductNotExistException::new);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
