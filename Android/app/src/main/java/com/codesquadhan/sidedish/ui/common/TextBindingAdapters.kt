package com.codesquadhan.sidedish.ui.common

import android.graphics.Paint
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.codesquadhan.sidedish.R
import java.text.DecimalFormat
import androidx.core.content.ContextCompat

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.currency, decimalFormat.format(price))
}

@BindingAdapter("priceAmount", "strikeThrough")
fun applySalePriceTextView(view: TextView, price: Int, saleType: String?) {
    applyPriceFormat(view, price)
    view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    view.isVisible = saleType != "NONE"

    // 리사이클러뷰 뷰홀더 재활용으로 인해  saleType이 NONE 일때 GONE 이 되게만 처리를 해두면, NONE이 아닌 메뉴에서도 정가부분이 GONE 되는 이슈 발생
    // else 문을 추가해서 NONE이 아니면 VISIBLE 되도록 명시적으로 선언하니 오류 해결
}

@BindingAdapter("badgeVisible")
fun applyBadgeVisibility(view: CardView, saleType: String?) {
    view.isVisible = saleType != "NONE"
}

@BindingAdapter("badgeBackground")
fun applyBadgeBackground(view: ConstraintLayout, saleType: String?) {
    if (saleType == "LAUNCH") view.setBackgroundColor(
        ContextCompat.getColor(
            view.context,
            R.color.Primary1
        )
    )
    else view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.Primary3))
}

@BindingAdapter("badgeText")
fun applyBadgeText(view: TextView, saleType: String?) {
    if (saleType == "LAUNCH") {
        view.text = view.context.getString(R.string.text_tag_launching)
        view.setTextColor(ContextCompat.getColor(view.context, R.color.Primary3))
    } else {
        view.text = view.context.getString(R.string.text_tag_event)
        view.setTextColor(ContextCompat.getColor(view.context, R.color.Primary2))

    }
}

@BindingAdapter("deliveryFee", "freeDeliveryFee")
fun applyDeliveryFeeText(view: TextView, deliveryFee: Int, freeDeliveryFee: Int) {
    val decimalFormat = DecimalFormat("#,###")
    val deliveryFee = view.context.getString(R.string.currency, decimalFormat.format(deliveryFee))
    val freeDeliveryFee = view.context.getString(R.string.currency, decimalFormat.format(freeDeliveryFee))
    val freeDeliveryFeeInfo = view.context.getString(R.string.detail_delivery_info_free, deliveryFee, freeDeliveryFee)
    view.text = freeDeliveryFeeInfo
}

@BindingAdapter("orderCount", "salePrice")
fun applyTotalPayText(view: TextView, orderCount: Int, salePrice: Int) {
    val decimalFormat = DecimalFormat("#,###")
    val total = orderCount * salePrice
    view.text = view.context.getString(R.string.currency, decimalFormat.format(total))
}