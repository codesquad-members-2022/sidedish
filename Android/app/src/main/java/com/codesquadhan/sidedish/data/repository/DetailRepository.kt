package com.codesquadhan.sidedish.data.repository

import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.model.detail.DetailResponse
import com.codesquadhan.sidedish.network.DetailService
import com.codesquadhan.sidedish.network.MenuService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepository @Inject constructor(private val detailService: DetailService) {

    suspend fun getMenuDetail(id: Int): DetailResponse? {
        return detailService.getMenuDetail(id).getBodyOrThrow()
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if (this.isSuccessful) this.body() else throw java.lang.RuntimeException("Network error, please try again later\n")
    }

}