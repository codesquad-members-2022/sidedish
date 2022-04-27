package com.codesquadhan.sidedish.data.repository

import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.network.MenuService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuRepository @Inject constructor(private val menuService: MenuService) {

    suspend fun getMenuList(type: String): List<MainResponseItem>? {
        return menuService.getMenuList(type).getBodyOrThrow()
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if (this.isSuccessful) this.body() else throw java.lang.RuntimeException("Network error, please try again later\n")
    }

}