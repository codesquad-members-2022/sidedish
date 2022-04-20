package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Schema(description = "상품 목록 조회 결과")
@Getter
public class ProductListResponse {

    @Schema(description = "등록된 상품 수")
    private int count;

    @Schema(description = "상품 리스트")
    private List<ProductResponse> products;

    private ProductListResponse(int count, List<ProductResponse> products) {
        this.count = count;
        this.products = products;
    }

    public static ProductListResponseBuilder builder() {
        return new ProductListResponseBuilder();
    }

    public static class ProductListResponseBuilder {
        private int count;
        private List<ProductResponse> products = new ArrayList<>();

        public ProductListResponseBuilder count(int count) {
            this.count = count;
            return this;
        }

        public ProductListResponseBuilder addProducts(ProductResponse productResponse) {
            this.products.add(productResponse);
            return this;
        }

        public ProductListResponseBuilder addAllProducts(Collection<ProductResponse> productResponses) {
            this.products.addAll(productResponses);
            return this;
        }

        public ProductListResponse build() {
            return new ProductListResponse(this.count, this.products);
        }
    }
}
