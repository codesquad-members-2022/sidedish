package com.example.todo.sidedish.ui.common

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo.sidedish.R
import java.text.DecimalFormat

@BindingAdapter("cancelText")
fun loadOriginalPrice(view: TextView, price: String?) {
    if (!price.isNullOrEmpty()) {
        view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        view.text = price
    }
}

@BindingAdapter("nowPageNum", "totalPageNum")
fun displayPageInfo(view: TextView, nowPageNum: Int, totalPageNum: Int) {
    view.text = view.context.getString(R.string.page_format, nowPageNum, totalPageNum)
}

@BindingAdapter("getCount")
fun getMenuItemCount(view: TextView, itemCount: Int) {
    view.text = view.context.getString(R.string.order_count_format, itemCount)
}

@BindingAdapter("formatText")
fun formatText(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.price_format, decimalFormat.format(price))
}