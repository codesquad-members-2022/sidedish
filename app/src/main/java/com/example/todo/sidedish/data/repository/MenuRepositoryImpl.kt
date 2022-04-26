package com.example.todo.sidedish.data.repository

import com.example.todo.sidedish.data.dto.toMenu
import com.example.todo.sidedish.data.dto.toMenuDetail
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.data.remote.DataSource
import com.example.todo.sidedish.domain.Repository
import com.example.todo.sidedish.domain.model.MenuDetail
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val onBanDataSource: DataSource,
) : Repository {

    override suspend fun getMain(): List<Menu> {
        val response = onBanDataSource.getMain()
        return response.dish.map { it.toMenu() }
    }

    override suspend fun getSoup(): List<Menu> {
        val response = onBanDataSource.getSoup()
        return response.dish.map { it.toMenu() }
    }

    override suspend fun getSide(): List<Menu> {
        val response = onBanDataSource.getSide()
        return response.dish.map { it.toMenu() }
    }

    override suspend fun getDetail(detailHash: String): MenuDetail {
        return onBanDataSource.getDetail(detailHash)
            .data.toMenuDetail()
    }


}