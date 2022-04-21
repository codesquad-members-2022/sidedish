package com.example.sidedish

import com.google.gson.annotations.SerializedName

data class ProductDetailTitleImage(
    @SerializedName("product_detail_title_image")
    val productDetailTitleImageList: List<ProductDetailTitleImageList>
)

data class ProductDetailTitleImageList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("product_detail_image_url")
    val productDetailImageURL: String
)

data class ProductDetailContents(
    @SerializedName("title")
    val title: String,
    @SerializedName("contents")
    val contents: String,
    @SerializedName("original_price")
    val originalPrice: Int,
    @SerializedName("sale_price")
    val salePrice: Int,
    @SerializedName("badge")
    val badge: String,
    @SerializedName("saved_money")
    val savedMoney: Int,
    @SerializedName("delivery_information")
    val deliveryInformation: String,
    @SerializedName("delivery_price")
    val deliveryPrice: Int,
    @SerializedName("product_detail_contents_image")
    val productDetailContentsImage: String
)
