package com.example.sidedish

class ProductDetailRepository(private val productDetailImageDataSource: ProductDetailImageDataSource) {

    fun loadProductDetailImage(): ProductDetailTitleImage? {
        return productDetailImageDataSource.loadProductDetailImage()
    }
}