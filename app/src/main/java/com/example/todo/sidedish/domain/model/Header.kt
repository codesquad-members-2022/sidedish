package com.example.todo.sidedish.domain.model

data class Header(
    val type: DishType,
    var visible: Boolean = false,
    var dishCount: Int = 0
) : MenuItem()