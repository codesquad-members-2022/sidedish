package com.codesquadhan.sidedish.network

import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.model.detail.DetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {


    @GET("detail/{id}")
    suspend fun getMenuDetail(
        @Path("id") id: Int
    ): Response<DetailResponse>


}