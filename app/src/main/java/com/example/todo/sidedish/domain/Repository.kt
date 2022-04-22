package com.example.todo.sidedish.domain

import com.example.todo.sidedish.domain.model.Menu

interface Repository {

    suspend fun getMain(): Result<List<Menu>>

    suspend fun getSoup(): Result<List<Menu>>

    suspend fun getSide(): Result<List<Menu>>
}