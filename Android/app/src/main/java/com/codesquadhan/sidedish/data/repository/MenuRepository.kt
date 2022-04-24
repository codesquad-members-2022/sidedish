package com.codesquadhan.sidedish.data.repository

import com.codesquadhan.sidedish.data.model.be.MainResponse
import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.model.onban.OnbanMainResponse
import com.codesquadhan.sidedish.network.MenuService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import javax.inject.Inject


class MenuRepository @Inject constructor(private val menuService: MenuService) {

/*    suspend fun getOnbanMenu(): Response<OnbanMainResponse> {
        return menuService.getMainMenu()
    }*/

    suspend fun getMainMenu(): Response<List<MainResponseItem>> = menuService.getMainMenu()
    suspend fun getSoupMenu(): Response<List<MainResponseItem>> = menuService.getSoupMenu()
    suspend fun getSideMenu(): Response<List<MainResponseItem>> = menuService.getSideMenu()

}