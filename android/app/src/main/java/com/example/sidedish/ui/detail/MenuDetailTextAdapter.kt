package com.example.sidedish.ui.detail

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.sidedish.R
import java.text.DecimalFormat

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.currency, decimalFormat.format(price))
}

@BindingAdapter("discountedPrice", "discountRate")
fun applyPriceDiscount(view: TextView, price: Int, discountRate: Int?) {
    val discount = discountRate ?: 0
    val discountPrice = ((100 - discount) * price) / 100
    applyPriceFormat(view, discountPrice)
}

@BindingAdapter("originalPrice", "discountRate")
fun showOriginalPrice(view: TextView, price: Int, discountRate: Int?) {
    if (discountRate == null) {
        view.visibility = View.INVISIBLE
    } else {
        view.visibility = View.VISIBLE
        view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        applyPriceFormat(view, price)
    }
}

@BindingAdapter("totalAmount")
fun applyTotalAmount(view: TextView, totalPrice: Int) {
    applyPriceFormat(view, totalPrice)
}

@BindingAdapter("launchingPolicy")
fun applyLaunchingDiscountPolicy(view: TextView, policy: String?) {
    when (policy) {
        "런칭특가" -> {
            view.visibility = View.VISIBLE
        }
        else -> {
            view.visibility = View.GONE
        }
    }
}

@BindingAdapter("eventPolicy")
fun applyEventDiscountPolicy(view: TextView, policy: String?) {
    when (policy) {
        "이벤트특가" -> {
            view.visibility = View.VISIBLE
        }
        else -> {
            view.visibility = View.GONE
        }
    }
}