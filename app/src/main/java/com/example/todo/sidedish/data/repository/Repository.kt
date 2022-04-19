package com.example.todo.sidedish.data.repository

import com.example.todo.sidedish.common.Result
import com.example.todo.sidedish.model.Menu

interface Repository {

    suspend fun getMain(): Result<List<Menu>>

    suspend fun getSoup(): Result<List<Menu>>

    suspend fun getSide(): Result<List<Menu>>
}