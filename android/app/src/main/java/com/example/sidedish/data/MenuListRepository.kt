package com.example.sidedish.data

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuListRepository @Inject constructor(private val dataSource: DataSource) {

    suspend fun getSelectedFoodDetail(id: Int): Menu? {
        return dataSource.getFoodDetail(id).getBodyOrThrow()?.inputDTOToMenu()
    }

    suspend fun getMenuList(category: Int): List<Menu> {
        val response = dataSource.getMenuList(category)
        return response.getBodyOrThrow()?.changeData() ?: emptyList()
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if(this.isSuccessful) this.body() else throw java.lang.RuntimeException("network fail")
    }

}