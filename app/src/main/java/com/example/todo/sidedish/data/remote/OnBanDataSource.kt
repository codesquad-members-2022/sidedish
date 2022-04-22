package com.example.todo.sidedish.data.remote

import com.example.todo.sidedish.data.dto.MenuDto
import javax.inject.Inject

class OnBanDataSource @Inject constructor(
    private val api: OnBanApi,
) : DataSource {
    override suspend fun getMain(): MenuDto = api.getMain()

    override suspend fun getSoup(): MenuDto = api.getSoup()

    override suspend fun getSide(): MenuDto = api.getSide()
}