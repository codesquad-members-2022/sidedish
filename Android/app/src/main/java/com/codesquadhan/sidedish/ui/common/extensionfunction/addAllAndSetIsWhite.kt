package com.codesquadhan.sidedish.ui.common

import com.codesquadhan.sidedish.data.model.be.MainResponseItem

fun <T> MutableList<T>.addAllAndSetIsWhite(menuList: List<T>) {
    this.addAll(menuList)
    menuList.forEach {
        it as MainResponseItem
        it.isWhite = false
    }
}