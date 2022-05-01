package com.codesquadhan.sidedish.network

import com.codesquadhan.sidedish.data.model.detail.DetailResponse
import com.codesquadhan.sidedish.data.model.detail.OrderRequest
import com.codesquadhan.sidedish.data.model.detail.OrderRequestResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DetailService {

    @GET("menus/detail/{id}")
    suspend fun getMenuDetail(@Path("id") id: Int): Response<DetailResponse>

    @POST("menus/detail/{id}")
    suspend fun orderMenu(
        @Path("id") id: Int,
        @Body orderRequest: OrderRequest
    ): Response<OrderRequestResponse>

}