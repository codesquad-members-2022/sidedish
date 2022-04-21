package com.example.sidedish

import java.util.*

data class MenuData(
    val id: Int,
    val productName: String,
    val description: String,
    val representImages: RepresentImages,
    val detailImages: DetailImages,
    val price: Int,
    val discountPrice: Int,
    val stockQuantity: Int,
    val eventInfo: String?
)

class Menu(
    val id: Int,
    val productName: String,
    val description: String,
    val representImages: RepresentImages,
    val detailImages: DetailImages,
    val price: Int,
    val discountPrice: Int,
    val stockQuantity: Int,
    val eventInfo: String?
)

data class RepresentImages(
    val imageId: Int,
    val imageURL: String,
    val representYn: Boolean,
    val sequence: Int
)

data class DetailImages(
    val imageId: Int,
    val imageURL: String,
    val representYn: Boolean,
    val sequence: Int
)