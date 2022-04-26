package com.example.sidedish.data


import com.google.gson.annotations.SerializedName


data class Item(
    @SerializedName("categoryName")
    val categoryName: String?,
    @SerializedName("items")
    val items: List<ItemX>?
)

data class ItemX(
    @SerializedName("description")
    val description: String?,
    @SerializedName("discountPoilcy")
    val discountPoilcy: String?,
    @SerializedName("discountRate")
    val discountRate: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("mainImageLink")
    val mainImageLink: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Int?
)

fun Item.changeData(): List<Menu> {
    val list = mutableListOf<Menu>()
    this.items?.forEach {
        list.add(it.changeData())
    }
    return list
}

fun ItemX.changeData(): Menu = Menu(description, discountPoilcy, discountRate, id, mainImageLink, name, price, null)