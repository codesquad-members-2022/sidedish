package com.example.sidedish.ui.common

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.sidedish.R
import java.text.DecimalFormat

@BindingAdapter("updateImage")
fun updateImage(view: ImageView, imageUrl: String?) {
    if (imageUrl != null) {
        GlideApp.with(view)
            .load(imageUrl)
            .error(androidx.appcompat.R.drawable.abc_btn_borderless_material)
            .into(view)
    }
}

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.unit_currency, decimalFormat.format(price))
}

@BindingAdapter("showBadgeBackground")
fun showBadgeBackground(view: TextView, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
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
fun updateVisible(view: TextView, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}