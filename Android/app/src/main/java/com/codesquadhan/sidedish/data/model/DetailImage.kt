package com.codesquadhan.sidedish.data.model

data class DetailImage(
    val id: Int = 1,
    val menuId: Int,
    val imagePath: String,
    val isMainImage: Boolean
)
