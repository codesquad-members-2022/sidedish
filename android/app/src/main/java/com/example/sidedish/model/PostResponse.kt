package com.example.sidedish.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("errorMessage")
    val errorMessage: String?
)
