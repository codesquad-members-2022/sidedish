package com.example.sidedish.network

import com.example.sidedish.model.Error
import okhttp3.ResponseBody

object NetworkUtil {
    fun getErrorResponse(errorBody: ResponseBody?): Error? {
        return errorBody?.let {
            RetrofitAPI.retrofit.responseBodyConverter<Error>(
                Error::class.java,
                Error::class.java.annotations
            ).convert(it)
        }
    }
}