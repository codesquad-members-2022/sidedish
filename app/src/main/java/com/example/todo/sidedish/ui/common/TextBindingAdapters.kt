package com.example.todo.sidedish.ui.common

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo.sidedish.R

@BindingAdapter("cancelText")
fun loadOriginalPrice(view: TextView, price: String?) {
    if (!price.isNullOrEmpty()) {
        view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        view.text = price
    }
}