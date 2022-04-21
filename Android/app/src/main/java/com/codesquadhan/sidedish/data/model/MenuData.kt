package com.codesquadhan.sidedish.data.model

data class MenuData(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val menuType: Int = 1,
    val saleType: Int = 1,
    val fee: Int = 1,
    val freeShippingMin: Int = 1,
    val deliveryInfo: String = "",
    val inventory: Int = 1,
    val imageId: Int = 1,
    val viewType: Int = 2,
    val headerText: String = ""
)
