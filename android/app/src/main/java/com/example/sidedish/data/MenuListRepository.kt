package com.example.sidedish.data

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuListRepository @Inject constructor(private val dataSource: DataSource) {

    suspend fun getMainFoodList(): List<Body>? {
        val data = dataSource.getMainFoodList()
        return when (data.isSuccessful) {
            true -> data.body()?.body
            false -> throw RuntimeException("network fail")
        }
    }

    suspend fun getSoupFoodList(): List<Body>? {
        val data = dataSource.getSoupFoodList()
        return when (data.isSuccessful) {
            true -> data.body()?.body
            false -> throw RuntimeException("network fail")
        }
    }

    suspend fun getSideFoodList(): List<Body>? {
        val data = dataSource.getSideFoodList()
        return when (data.isSuccessful) {
            true -> data.body()?.body
            false -> throw RuntimeException("network fail")
        }
    }

    suspend fun getSelectedFoodDetail(hashId: String): Detail? {
        val data = dataSource.getFoodDetail(hashId)
        return when (data.isSuccessful) {
            true -> data.body()?.data
            false -> throw RuntimeException("Detail network fail")
        }
    }

    private fun <T : Any> Response<T>.getBodyOrThrow(): T? {
        return if(this.isSuccessful) this.body() else throw java.lang.RuntimeException("network fail")
    }

}