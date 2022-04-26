package com.example.sidedish.ui.common

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.sidedish.R

@BindingAdapter("updateImage")
fun updateImage(view: ImageView, imageUrl: String?) {
    if (imageUrl != null) {
        GlideApp.with(view)
            .load(imageUrl)
            .error(androidx.appcompat.R.drawable.abc_btn_borderless_material)
            .into(view)
    }
}

@BindingAdapter("showBadgeBackground")
fun showBadgeBackground(view: TextView, text: String?) {
    if (text == null) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("makeStroke")
fun makeStroke(view: TextView, text: String) {
    view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
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