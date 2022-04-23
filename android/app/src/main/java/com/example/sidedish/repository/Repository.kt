package com.example.sidedish.repository

import com.example.sidedish.network.ApiService
import javax.inject.Inject

// Apiservice 를 주입받음
class Repository
@Inject
constructor(private val apiService: ApiService){
    suspend fun getMainMenu() = apiService.getMainMenu()

}