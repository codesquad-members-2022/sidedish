package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodDetail
import com.example.sideDish.network.SideDishRetrofitService
import com.example.sideDish.network.dto.toFoodDetail

class DetailRemoteRepository(
    private val sideDishRetrofitService: SideDishRetrofitService
) : DetailRepository {
    override suspend fun getDetail(detailHash: String): FoodDetail? {
        val response = sideDishRetrofitService.getDetail(detailHash)
        return if (response.isSuccessful) {
            response.body()?.toFoodDetail()
        } else null
    }
}