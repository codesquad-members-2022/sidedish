package com.example.sidedish

import com.google.gson.annotations.SerializedName

data class ProductDetailImage(
    @SerializedName("product_detail_image")
    val productDetailImageList: List<ProductDetailImageList>
)

data class ProductDetailImageList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("product_detail_image_url")
    val productDetailImageURL: String
)
