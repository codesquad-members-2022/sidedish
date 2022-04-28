package com.codesquadhan.sidedish.ui.common

import com.codesquadhan.sidedish.data.model.be.MainResponseItem

fun <T> MutableList<T>.addAllAndSetIsWhite(menuList: List<T>) {
    this.addAll(menuList)
    menuList.forEach {
        if (it is MainResponseItem) {
            it.isWhite = false
        }
    }
}