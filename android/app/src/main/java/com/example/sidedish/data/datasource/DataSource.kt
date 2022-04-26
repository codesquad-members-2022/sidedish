package com.example.sidedish.data.datasource

import com.example.sidedish.data.dto.Item
import com.example.sidedish.data.dto.MenuDetailDTO
import retrofit2.Response


interface DataSource {

    suspend fun getMenuList(category: Int): Response<Item>

    suspend fun getFoodDetail(id: Int): Response<MenuDetailDTO>
}