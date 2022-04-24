package com.codesquadhan.sidedish.network

import com.codesquadhan.sidedish.data.model.be.MainResponse
import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.model.onban.OnbanMainResponse
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {

  /*  @GET("main")
    suspend fun getMainMenu(): Response<OnbanMainResponse>*/

    @GET("main")
    suspend fun getMainMenu(): Response<List<MainResponseItem>>

    @GET("soup")
    suspend fun getSoupMenu(): Response<List<MainResponseItem>>

    @GET("side")
    suspend fun getSideMenu(): Response<List<MainResponseItem>>

}