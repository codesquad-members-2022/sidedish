package com.codesquadhan.sidedish.ui.common

import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter

@BindingAdapter("isNetworkError")
fun applyLayoutVisibility(view: ViewGroup, isError: Boolean) {
    if (isError) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}