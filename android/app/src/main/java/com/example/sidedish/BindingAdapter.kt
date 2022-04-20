package com.example.sidedish

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("updateImage")
fun updateImage(view: ImageView, imageUrl: String) {
    GlideApp.with(view)
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("updatePrice")
fun updatePrice(view: TextView, body: String?) {
    view.text = body
    view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    if (body == null) {
        view.visibility = View.GONE
    }
}

@BindingAdapter("updateEvent")
fun updateEvent(view: TextView, event: String?) {
    if (event == null) {
        view.visibility = View.GONE
    }
}