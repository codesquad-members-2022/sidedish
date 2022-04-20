package com.example.todo.sidedish.data.repository

import com.example.todo.sidedish.common.Constants.NETWORK_ERROR_MESSAGE
import com.example.todo.sidedish.common.Constants.STATUS_CODE_GET_SUCCESS
import com.example.todo.sidedish.common.Result
import com.example.todo.sidedish.data.dto.toMenu
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.data.remote.DataSource
import com.example.todo.sidedish.domain.Repository
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val onBanDataSource: DataSource,
) : Repository {

    override suspend fun getMain(): Result<List<Menu>> {
        val response = onBanDataSource.getMain()
        val mainMenus = response.body
            ?.map { it.toMenu() }
        if (response.statusCode == STATUS_CODE_GET_SUCCESS) {
            return Result.Success(mainMenus)
        }
        return Result.Error(NETWORK_ERROR_MESSAGE, null)
    }

    override suspend fun getSoup(): Result<List<Menu>> {
        val response = onBanDataSource.getSoup()
        val soupMenus = response.body
            ?.map { it.toMenu() }
        if (response.statusCode == STATUS_CODE_GET_SUCCESS) {
            return Result.Success(soupMenus)
        }
        return Result.Error(NETWORK_ERROR_MESSAGE, null)
    }

    override suspend fun getSide(): Result<List<Menu>> {
        val response = onBanDataSource.getSide()
        val sideMenus = response.body
            ?.map { it.toMenu() }
        if (response.statusCode == STATUS_CODE_GET_SUCCESS) {
            return Result.Success(sideMenus)
        }
        return Result.Error(NETWORK_ERROR_MESSAGE, null)
    }
}