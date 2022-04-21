package com.codesquadhan.sidedish.data.repository

import com.codesquadhan.sidedish.data.model.onban.OnbanMainResponse
import com.codesquadhan.sidedish.network.MenuService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import javax.inject.Inject


class MenuRepository @Inject constructor(private val menuService: MenuService) {

    suspend fun getOnbanMenu(): Response<OnbanMainResponse> {
        return menuService.getMainMenu()
    }

}