package com.codesquadhan.sidedish.ui.common

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.codesquadhan.sidedish.R

@BindingAdapter("isWhite")
fun bindRecyclerViewColor(view: View, isWhite: Boolean) {
    when (isWhite) {
        true -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.White))
        false -> view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.Grey4))
    }
}