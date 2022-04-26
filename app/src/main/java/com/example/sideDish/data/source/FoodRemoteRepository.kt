package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.FoodDetail
import com.example.sideDish.data.model.Item
import com.example.sideDish.network.SideDishRetrofitService
import com.example.sideDish.network.dto.toItems

class FoodRemoteRepository(private val sideDishRetrofitService: SideDishRetrofitService) :
    FoodRepository {
    override suspend fun getMenu(foodCategory: FoodCategory): List<Item>? {
        val response = when (foodCategory) {
            FoodCategory.MAIN -> sideDishRetrofitService.getMainMenu()
            FoodCategory.SOUP -> sideDishRetrofitService.getSoupMenu()
            FoodCategory.SIDE -> sideDishRetrofitService.getSideMenu()
        }
        return if (response.isSuccessful) {
            response.body()?.toItems(foodCategory)
        } else null
    }


}