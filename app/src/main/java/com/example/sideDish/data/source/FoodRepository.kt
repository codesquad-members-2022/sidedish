package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item

interface FoodRepository {
    suspend fun getMenu(foodCategory: FoodCategory): List<Item>

}