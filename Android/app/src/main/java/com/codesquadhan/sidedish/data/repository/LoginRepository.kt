package com.codesquadhan.sidedish.data.repository

import com.codesquadhan.sidedish.network.LoginService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(private val loginService: LoginService) {


    suspend fun doLogin(){
        loginService.doLogin()
    }
}