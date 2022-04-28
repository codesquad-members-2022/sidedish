package com.example.sidedish.data.dto


import com.google.gson.annotations.SerializedName

data class JwtDTO(
    @SerializedName("accessToken")
    val accessToken: String?,
    @SerializedName("tokenType")
    val tokenType: String?
)

fun JwtDTO.changeJWT(): String? =
    when (this.accessToken != null && this.tokenType != null) {
        true -> "${this.tokenType} ${this.accessToken}"
        false -> null
    }
