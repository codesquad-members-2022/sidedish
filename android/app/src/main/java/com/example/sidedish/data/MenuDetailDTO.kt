package com.example.sidedish.data


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

fun MenuDetailDTO.inputDTOToMenu(): Menu {
    val newMenu = Menu(description, discountPolicy, discountRate, id, mainImageLink, name, price, null)
    newMenu.makeDetailImageLinkList(detailImageLink)
    return newMenu
}
