package com.example.sidedish.data.datasource

import com.example.sidedish.network.ApiClient
import javax.inject.Inject

class MenuListDataSource @Inject constructor(private val api: ApiClient) : DataSource {

    override suspend fun getMenuList(category: Int) = api.getMenuList(category)

    override suspend fun getFoodDetail(id: Int) = api.getProductDetail(id)
}