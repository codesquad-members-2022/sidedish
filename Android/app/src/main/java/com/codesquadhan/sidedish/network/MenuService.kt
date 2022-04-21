package com.codesquadhan.sidedish.network

import com.codesquadhan.sidedish.data.model.onban.OnbanMainResponse
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {

    @GET("main")
    suspend fun getMainMenu(): Response<OnbanMainResponse>
}