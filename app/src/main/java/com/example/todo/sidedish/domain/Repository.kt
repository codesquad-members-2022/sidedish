package com.example.todo.sidedish.domain

import com.example.todo.sidedish.common.Result
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.domain.model.MenuDetail

interface Repository {

    suspend fun getMain(): Result<List<Menu>>

    suspend fun getSoup(): Result<List<Menu>>

    suspend fun getSide(): Result<List<Menu>>

    suspend fun getDetail(hash:String) : MenuDetail
}