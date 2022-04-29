package com.example.sidedish.repository

import com.example.sidedish.model.MenuData

interface MainDataSource {

    suspend fun loadMainMenu(): MenuData?

    suspend fun loadSoupMenu(): MenuData?

    suspend fun loadSideDish(): MenuData?
}