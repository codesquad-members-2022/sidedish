package com.example.sidedish

import retrofit2.Response
import javax.inject.Inject

//Apiservice를 주입받음
class Repository
@Inject
constructor(private val apiService: ApiService){
    suspend fun getMainMenu() = apiService.getMainMenu()

}