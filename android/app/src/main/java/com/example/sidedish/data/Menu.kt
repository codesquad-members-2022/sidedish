package com.example.sidedish.data

import com.example.sidedish.data.dto.DetailImageLinkDTO

data class Menu(
    val description: String?,
    val discountPolicy: String?,
    val discountRate: Int?,
    val id: Int?,
    val mainImageLink: String?,
    val name: String?,
    val price: Int?,
    var detailImageLink: List<DetailImageLinks>?
): MenuModel() {
    fun makeDetailImageLinkList(list: List<DetailImageLinkDTO>?) {
        val newList = mutableListOf<DetailImageLinks>()
        list?.forEach { detailImageLink ->
            newList.add(DetailImageLinks(detailImageLink.id, detailImageLink.imageLinks))
        }
        detailImageLink = newList.toList()
    }
}

data class DetailImageLinks(
    val id: Int?,
    val imageLink: String?
)