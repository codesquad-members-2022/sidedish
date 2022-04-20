package com.example.sidedish

data class MenuData(
    val id: Int,
    val category: String,
    val image: String,
    val name: String,
    val body: String,
    val discountPrice: String,
    val price: String?,
    val eventCategory: String?
)

fun mainPut(): List<MenuData> {
    val str1 = MenuData(
        1, "main",
        "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
        "오리주물럭",
        "매우맛있음",
        "8000",
        "10000",
        "런칭특가"
    )

    val str2 = MenuData(
        2, "main",
        "http://public.codesquad.kr/jk/storeapp/data/main/310_ZIP_P_0012_T.jpg",
        "잡채",
        "불닭맛이남",
        "6000",
        "8000",
        "이벤트특가"
    )

    val str3 = MenuData(
        3, "main",
        "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg",
        "소갈비찜",
        "존맛",
        "6000",
        null,
        null
    )
    return listOf(str1, str2, str3)
}

fun soupPut(): List<MenuData> {
    val str1 = MenuData(
        1, "soup",
        "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_T.jpg",
        "돼지 김치찌개",
        "찌개는 언제나옳다",
        "9000",
        "10000",
        "런칭특가"
    )
    return listOf(str1)
}

fun sidePut(): List<MenuData> {
    val str1 = MenuData(
        1, "side",
        "http://public.codesquad.kr/jk/storeapp/data/side/682_ZIP_P_5055_T.jpg",
        "미나리 무침",
        "보라색맛",
        "7000",
        "10000",
        "이벤트특가"
    )
    return listOf(str1)
}