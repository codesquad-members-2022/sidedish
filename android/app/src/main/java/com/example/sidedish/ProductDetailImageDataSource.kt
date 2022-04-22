package com.example.sidedish

import com.google.gson.Gson

class ProductDetailImageDataSource(private val assetLoader: AssetLoader) : ProductDetailDataSource {

    private val gson = Gson()

    override fun loadProductDetailImage(): ProductDetailImage? {
        return assetLoader.getJsonString("product_detail.json")?.let { jsonString ->
            gson.fromJson(jsonString, ProductDetailImage::class.java)
        }
    }
}