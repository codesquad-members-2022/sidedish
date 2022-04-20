package com.example.sidedish.data

import com.example.sidedish.network.ApiClient

class MenuListDataSource(private val api: ApiClient): DataSource {

    override suspend fun getMainFoodList() = api.getMainFoodList()

    override suspend fun getSoupFoodList() = api.getSoupFoodList()

    override suspend fun getSideFoodList() = api.getSideFoodList()
}