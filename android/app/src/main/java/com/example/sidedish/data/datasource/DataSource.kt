package com.example.sidedish.data.datasource

import com.example.sidedish.data.dto.Item
import com.example.sidedish.data.dto.JwtDTO
import com.example.sidedish.data.dto.MenuDetailDTO
import retrofit2.Response


interface DataSource {

    suspend fun getMenuList(token: String, category: Int): Response<Item>

    suspend fun getFoodDetail(token: String, id: Int): Response<MenuDetailDTO>

    suspend fun getJWT(code: String): Response<JwtDTO>
}