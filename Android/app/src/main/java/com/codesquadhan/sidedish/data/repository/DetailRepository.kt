package com.codesquadhan.sidedish.data.repository

import com.codesquadhan.sidedish.data.model.detail.DetailResponse
import com.codesquadhan.sidedish.data.model.detail.OrderRequest
import com.codesquadhan.sidedish.data.model.detail.OrderRequestResponse
import com.codesquadhan.sidedish.network.DetailService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepository @Inject constructor(private val detailService: DetailService) {

    suspend fun getMenuDetail(id: Int): DetailResponse? {
        return detailService.getMenuDetail(id).getBodyOrThrow()
    }

    suspend fun orderFood(menuId: Int, orderQuantity: Int): OrderRequestResponse? {
        val orderRequest = OrderRequest(orderQuantity)
        return detailService.orderMenu(menuId, orderRequest).getBodyOrThrow()
    }

    private fun <T> Response<T>.getBodyOrThrow(): T? {
        return if (this.isSuccessful) this.body() else throw java.lang.Exception("${this.message()} Error occurred, please try again later\n")
    }

}