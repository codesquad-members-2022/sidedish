package com.example.sidedish.data.datasource

import com.example.sidedish.data.OrderMenu
import com.example.sidedish.network.ApiClient
import retrofit2.Response
import javax.inject.Inject

class MenuListDataSource @Inject constructor(private val api: ApiClient) : DataSource {

    override suspend fun getMenuList(token: String, category: Int) = api.getMenuList(token, category)

    override suspend fun getFoodDetail(token: String, id: Int) = api.getProductDetail(token, id)

    override suspend fun getJWT(code: String) = api.getJWT(code)

    override suspend fun orderMenu(token: String, menu: OrderMenu) = api.orderMenu(token, body = menu)
}