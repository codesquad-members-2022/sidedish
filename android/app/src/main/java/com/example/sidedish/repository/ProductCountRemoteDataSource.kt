package com.example.sidedish.repository

import com.example.sidedish.model.PostRequest

interface ProductCountRemoteDataSource {

    suspend fun orderProduct(postRequest: PostRequest): String?
}