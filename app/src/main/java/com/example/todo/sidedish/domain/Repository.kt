package com.example.todo.sidedish.domain

import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.domain.model.MenuDetail

interface Repository {

    suspend fun getMain(): List<Menu>

    suspend fun getSoup(): List<Menu>

    suspend fun getSide(): List<Menu>

    suspend fun getDetail(hash:String) : MenuDetail
}