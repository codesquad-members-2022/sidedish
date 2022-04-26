package com.example.sideDish.data.model

sealed class Item {

    data class Section(
        val category: FoodCategory
    ): Item()

    data class FoodInfo(
        val alt: String,
        val badge: List<String>,
        val deliveryType: List<String>,
        val description: String,
        val detailHash: String,
        val image: String,
        val nPrice: String,
        val sPrice: String,
        val title: String
    ): Item()
}