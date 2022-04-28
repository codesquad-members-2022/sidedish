package com.example.sidedish.data.dto

import com.example.sidedish.data.DetailImageLinks
import com.example.sidedish.data.Menu

data class MenuDetailDTO(
    val id: Int?,
    val discountPolicy: String?,
    val discountRate: Int?,
    val description: String?,
    val name: String?,
    val price: Int?,
    val mainImageLink: String?,
    val detailImageLink: List<DetailImageLinkDTO>?
)

data class DetailImageLinkDTO(
    val id: Int?,
    val imageLinks: String?
)

fun MenuDetailDTO.inputDTOToMenu(): Menu = Menu(
    description,
    discountPolicy,
    discountRate,
    id,
    mainImageLink,
    name,
    price,
    detailImageLink = makeDetailImageLinkList(detailImageLink)
)

fun makeDetailImageLinkList(list: List<DetailImageLinkDTO>?): List<DetailImageLinks> {
    val newList = mutableListOf<DetailImageLinks>()
    list?.forEach { detailImageLink ->
        newList.add(DetailImageLinks(detailImageLink.id, detailImageLink.imageLinks))
    }
    return newList
}