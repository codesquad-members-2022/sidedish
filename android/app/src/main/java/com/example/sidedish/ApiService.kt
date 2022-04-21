package com.example.sidedish

import android.view.Menu
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products/1")
    suspend fun getMainMenu(): Response<List<MenuData>>

    //@Path("Int") variable: String
//    suspend fun getMainMenu(): List<MenuData>
//    suspend fun getSoupMenu(): List<MenuData>
//    suspend fun getSideMenu(): List<MenuData>
}