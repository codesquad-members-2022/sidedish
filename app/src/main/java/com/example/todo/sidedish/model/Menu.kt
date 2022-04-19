package com.example.todo.sidedish.model

data class Menu(
    val detailHash: String,
    val image: String,
    val alt: String,
    val deliveryType: List<String>,
    val title: String,
    val description: String,
    val nPrice: String?,
    val sPrice: String,
    val badge: List<String>?,
)
