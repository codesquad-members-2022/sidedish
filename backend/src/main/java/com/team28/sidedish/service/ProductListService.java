package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.controller.dto.ProductResponse;
import com.team28.sidedish.domain.Product;
import com.team28.sidedish.repository.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductListService {

    private final ProductService productService;
    private final DiscountService discountService;

    public ProductListResponse findProductList(Long categoryId) {
        List<ProductEntity> productEntities = productService.findProducts(categoryId);
        List<Product> products = convertToProducts(productEntities);
        List<ProductResponse> productResponses = convertToProductResponse(products);

        return new ProductListResponse(productResponses.size(), productResponses);
    }

    private List<Product> convertToProducts(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(product -> Product.of(product, discountService.findDiscountById(product.getDiscountId())))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<ProductResponse> convertToProductResponse(List<Product> products) {
        return products.stream()
                .map(ProductResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
