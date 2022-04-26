package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductDetailResponse;
import com.team28.sidedish.controller.dto.ProductImageResponse;
import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.controller.dto.ProductResponse;
import com.team28.sidedish.domain.Product;
import com.team28.sidedish.repository.entity.DiscountEntity;
import com.team28.sidedish.repository.entity.ProductEntity;
import com.team28.sidedish.repository.entity.ProductImageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductDiscountService {

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

    public ProductDetailResponse findProductDetail(Long productId) {
        ProductEntity productEntity = productService.findProductById(productId);
        DiscountEntity discountEntity = discountService.findDiscountById(productEntity.getDiscountId());

        Product product = Product.of(productEntity, discountEntity);

        return ProductDetailResponse.of(
                product,
                convertToProductImageResponses(product.getRepresentImages()),
                convertToProductImageResponses(product.getDetailImages())
        );
    }

    private static List<ProductImageResponse> convertToProductImageResponses(List<ProductImageEntity> images) {
        return images.stream()
                .map(ProductImageResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
