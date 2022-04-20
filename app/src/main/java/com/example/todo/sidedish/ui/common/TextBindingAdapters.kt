package com.example.todo.sidedish.ui.common

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo.sidedish.R

@BindingAdapter("checkEvent")
fun loadEventBadge(view: TextView, badge: List<String>?) {
    if (!badge.isNullOrEmpty()) {
        view.visibility = if(badge.contains(view.context.getString(R.string.label_event))) View.VISIBLE else View.GONE
    }
}

@BindingAdapter("checkLaunch")
fun loadLaunchBadge(view: TextView, badge: List<String>?) {
    if (!badge.isNullOrEmpty()) {
        view.visibility = if(badge.contains(view.context.getString(R.string.label_launch))) View.VISIBLE else View.GONE
    }
}

@BindingAdapter("cancelText")
fun loadOriginalPrice(view: TextView, price: String?) {
    if (!price.isNullOrEmpty()) {
        view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        view.text = price
    }
}