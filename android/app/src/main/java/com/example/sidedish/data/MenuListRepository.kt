package com.example.sidedish.data

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuListRepository @Inject constructor(private val dataSource: DataSource) {

    suspend fun getMainFoodList(): List<Body>? {
        return dataSource.getMainFoodList().getBodyOrThrow()?.body
    }

    suspend fun getSoupFoodList(): List<Body>? {
        return dataSource.getSoupFoodList().getBodyOrThrow()?.body
    }

    suspend fun getSideFoodList(): List<Body>? {
        return dataSource.getSideFoodList().getBodyOrThrow()?.body
    }

    suspend fun getSelectedFoodDetail(hashId: String): Detail? {
        return dataSource.getFoodDetail(hashId).getBodyOrThrow()?.data
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if(this.isSuccessful) this.body() else throw java.lang.RuntimeException("network fail")
    }

}