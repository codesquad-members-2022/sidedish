package com.example.sidedish.ui.common

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.sidedish.ui.common.GlideApp

@BindingAdapter("updateImage")
fun updateImage(view: ImageView, imageUrl: String) {
    GlideApp.with(view)
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("updateTextWithStroke")
fun updateTextWithStroke(view: TextView, body: Int?) {
    view.text = body.toString()
    view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    if (body == null) {
        view.visibility = View.GONE
    }
}

@BindingAdapter("updateVisible")
fun updateVisible(view: TextView, event: String?) {
    if (event == null) {
        view.visibility = View.GONE
    }
}