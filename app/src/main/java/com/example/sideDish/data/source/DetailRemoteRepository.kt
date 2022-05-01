package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodDetail
import com.example.sideDish.network.SideDishRetrofitService
import com.example.sideDish.network.dto.toFoodDetail
import javax.inject.Inject

class DetailRemoteRepository @Inject constructor(
    private val sideDishRetrofitService: SideDishRetrofitService
) : DetailRepository {
    override suspend fun getDetail(detailHash: String): FoodDetail {
        val response = sideDishRetrofitService.getDetail(detailHash)
        val body = response.body()
        return body.toFoodDetail()
    }
}