package com.example.sidedish.data.repository

import com.example.sidedish.data.*
import com.example.sidedish.data.dto.changeData
import com.example.sidedish.data.dto.inputDTOToMenu
import com.example.sidedish.data.datasource.DataSource
import com.example.sidedish.data.dto.changeJWT
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuListRepository @Inject constructor(private val dataSource: DataSource) {

    suspend fun getSelectedFoodDetail(token: String, id: Int): Menu? {
        return dataSource.getFoodDetail(token, id).getBodyOrThrow()?.inputDTOToMenu()
    }

    suspend fun getMenuList(token: String, category: Int): List<MenuModel> {
        val response = dataSource.getMenuList(token, category)
        val menuList = mutableListOf<MenuModel>()
        menuList.add(Category(response.getBodyOrThrow()?.categoryName))
        response.getBodyOrThrow()?.changeData()?.let { menuList.addAll(it) }
        return menuList
    }

    suspend fun getJWT(code: String) =
        dataSource.getJWT(code).getBodyOrThrow()?.changeJWT() ?: throw NullPointerException("JWT is null")

    suspend fun orderMenu(token: String, menu: OrderMenu): Boolean {
        return dataSource.orderMenu(token, menu).isSuccessful
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if (this.isSuccessful) this.body() else throw java.lang.RuntimeException("network fail")
    }

}