package com.codesquadhan.sidedish.network

import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MenuService {

    @GET("menus")
    suspend fun getMenuList(@Query("type") type: String): Response<List<MainResponseItem>>

}