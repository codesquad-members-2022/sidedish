package com.example.sideDish.data.source

import com.example.sideDish.data.model.FoodDetail

interface DetailRepository {

    suspend fun getDetail(detailHash: String): FoodDetail
}
