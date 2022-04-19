package com.example.sideDish

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProductDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_product_detail_fargment, container, false)

        // 추후 bindingAdapter 로 이전 예정
        val originPriceTextView: TextView =
            root.findViewById<TextView>(R.id.text_view_origin_price)
        originPriceTextView.paintFlags =
            originPriceTextView.paintFlags.or(Paint.STRIKE_THRU_TEXT_FLAG);

        return root
    }

}