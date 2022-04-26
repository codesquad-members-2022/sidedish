package com.example.sidedish.data.repository

import com.example.sidedish.data.*
import com.example.sidedish.data.dto.changeData
import com.example.sidedish.data.dto.inputDTOToMenu
import com.example.sidedish.data.datasource.DataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuListRepository @Inject constructor(private val dataSource: DataSource) {

    suspend fun getSelectedFoodDetail(id: Int): Menu? {
        return dataSource.getFoodDetail(id).getBodyOrThrow()?.inputDTOToMenu()
    }

    suspend fun getMenuList(category: Int): List<MenuModel> {
        val response = dataSource.getMenuList(category)
        val menuList = mutableListOf<MenuModel>()
        menuList.add(Category(response.getBodyOrThrow()?.categoryName))
        response.getBodyOrThrow()?.changeData()?.let { menuList.addAll(it) }
        return menuList
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if(this.isSuccessful) this.body() else throw java.lang.RuntimeException("network fail")
    }

}