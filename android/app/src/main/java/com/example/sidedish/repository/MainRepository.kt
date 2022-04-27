package com.example.sidedish.repository

import com.example.sidedish.model.MenuData

class MainRepository(private val mainRemoteDataSource: MainRemoteDataSource){

    suspend fun loadMainMenu(): MenuData? {
        return mainRemoteDataSource.loadMainMenu()
    }

    suspend fun loadSoupMenu(): MenuData? {
        return mainRemoteDataSource.loadSoupMenu()
    }

    suspend fun loadSideDish(): MenuData? {
        return mainRemoteDataSource.loadSideDish()
    }
}