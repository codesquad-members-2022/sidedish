package com.example.sidedish.data

import android.util.Log
import com.example.sidedish.network.ApiClient
import retrofit2.Response
import javax.inject.Inject

class MenuListDataSource @Inject constructor(private val api: ApiClient) : DataSource {

    override suspend fun getMenuList(category: Int) : Response<Item> {
        val d = api.getMenuList(category)
        Log.d("TAG", "rrrr ${d.body()}")
        return d
    }

    override suspend fun getFoodDetail(id: Int) = api.getProductDetail(id)
}