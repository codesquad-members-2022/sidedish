package com.example.sidedish.repository

import com.example.sidedish.model.MenuData
import com.example.sidedish.network.RetrofitAPI

class MainRemoteDataSource : MainDataSource {

    override suspend fun loadMainMenu(): MenuData? {
        val response = RetrofitAPI.service.getMainMenu()
        return if (response.isSuccessful) response.body() else null
    }

    override suspend fun loadSoupMenu(): MenuData? {
        val response = RetrofitAPI.service.getSoupMenu()
        return if (response.isSuccessful) response.body() else null
    }

    override suspend fun loadSideDish(): MenuData? {
        val response = RetrofitAPI.service.getSideDish()
        return if (response.isSuccessful) response.body() else null
    }
}