package com.example.sidedish.repository

import com.example.sidedish.model.MenuData
import javax.inject.Inject

class MainRepository @Inject constructor(private val mainDataSource: MainDataSource) {

    suspend fun loadMainMenu(): MenuData? {
        return mainDataSource.loadMainMenu()
    }

    suspend fun loadSoupMenu(): MenuData? {
        return mainDataSource.loadSoupMenu()
    }

    suspend fun loadSideDish(): MenuData? {
        return mainDataSource.loadSideDish()
    }
}