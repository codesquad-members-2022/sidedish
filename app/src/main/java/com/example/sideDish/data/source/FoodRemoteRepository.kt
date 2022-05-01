package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item
import com.example.sideDish.network.SideDishRetrofitService
import com.example.sideDish.network.dto.toItems
import javax.inject.Inject

class FoodRemoteRepository @Inject constructor(
    private val sideDishRetrofitService: SideDishRetrofitService
) : FoodRepository {
    override suspend fun getMenu(foodCategory: FoodCategory): List<Item> {
        val response = when (foodCategory) {
            FoodCategory.MAIN -> sideDishRetrofitService.getMainMenu()
            FoodCategory.SOUP -> sideDishRetrofitService.getSoupMenu()
            FoodCategory.SIDE -> sideDishRetrofitService.getSideMenu()
        }

        val body = response.body()
        return body.toItems(foodCategory)
    }
}