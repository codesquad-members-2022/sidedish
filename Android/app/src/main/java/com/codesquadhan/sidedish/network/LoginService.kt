package com.codesquadhan.sidedish.network

import retrofit2.http.GET

interface LoginService {

    @GET("login")
    suspend fun doLogin()
}