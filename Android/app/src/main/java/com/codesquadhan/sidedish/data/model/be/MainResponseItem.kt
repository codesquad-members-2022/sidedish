package com.codesquadhan.sidedish.data.model.be

import com.google.gson.annotations.SerializedName

data class MainResponseItem(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("imagePath")
    val imagePath: String = "",
    @SerializedName("menuType")
    val menuType: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: Int = -1,
    @SerializedName("salePrice")
    val salePrice: Int = -1,
    @SerializedName("saleType")
    val saleType: String = "",
    val viewType: Int = 2,
    val headerText: String = "",
    var isWhite: Boolean = true,
    var itemCount: Int = 0,
    var isHeaderClicked: Boolean = false
)