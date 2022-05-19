package com.sidedish.servcie;

import com.sidedish.domain.product.EventCategory;
import com.sidedish.domain.product.MainCategory;
import com.sidedish.domain.product.Product;
import com.sidedish.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findMainCategory(String category){
        return productRepository.findAllByMainCategory(MainCategory.valueOf(category));
    }

    public List<Product> findEventCategory(String category){
        return productRepository.findAllByEventCategory(EventCategory.valueOf(category));
    }

    public Product findOne(Long productId){
        return productRepository.findById(productId).orElseThrow(IllegalStateException::new);
    }

}
