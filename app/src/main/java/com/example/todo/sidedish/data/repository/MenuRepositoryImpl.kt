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

    override suspend fun getMain(): Result<List<Menu>> {
        return kotlin.runCatching {
            val response = onBanDataSource.getMain()
            response.dish.map { it.toMenu() }
        }
    }

    override suspend fun getSoup(): Result<List<Menu>> {
        return kotlin.runCatching {
            val response = onBanDataSource.getSoup()
            response.dish.map { it.toMenu() }
        }
    }

    override suspend fun getSide(): Result<List<Menu>> {
        return kotlin.runCatching {
            val response = onBanDataSource.getSide()
            response.dish.map { it.toMenu() }
        }
    }

    override suspend fun getDetail(detailHash: String): Result<MenuDetail> {
        val response = onBanDataSource.getDetail(detailHash)
        return kotlin.runCatching {
            response.data.toMenuDetail()
        }
    }


}