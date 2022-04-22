package com.team25.sidedish.service;

import com.team25.sidedish.domain.Product;
import com.team25.sidedish.exception.NotFoundException;
import com.team25.sidedish.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findProductsByCategoryId(categoryId)
            .orElseThrow(NotFoundException::new);
    }

    public Product getProductByProductId(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(NotFoundException::new);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
