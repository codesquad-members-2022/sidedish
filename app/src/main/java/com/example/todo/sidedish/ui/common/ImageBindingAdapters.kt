package com.example.todo.sidedish.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.todo.sidedish.common.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if(!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}