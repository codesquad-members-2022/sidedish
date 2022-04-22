package com.example.sidedish

class ProductDetailRepository(private val productDetailImageDataSource: ProductDetailImageDataSource) {

    fun loadProductDetailImage(): ProductDetailImage? {
        return productDetailImageDataSource.loadProductDetailImage()
    }
}