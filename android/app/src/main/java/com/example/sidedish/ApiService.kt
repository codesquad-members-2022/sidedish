package com.example.sidedish

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("products?categoryId=1")
    suspend fun getMainMenu(): Response<MenuData>


    //@Path("Int") variable: String
//    suspend fun getMainMenu(): List<MenuData>
//    suspend fun getSoupMenu(): List<MenuData>
//    suspend fun getSideMenu(): List<MenuData>
}