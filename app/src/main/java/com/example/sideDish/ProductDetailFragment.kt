package com.example.sideDish

import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class ProductDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_product_detail_fargment, container, false)
        val textViewIndex = root.findViewById<TextView>(R.id.text_view_image_index)
        // 추후 bindingAdapter 로 이전 예정
        val originPriceTextView: TextView =
            root.findViewById<TextView>(R.id.text_view_origin_price)
        originPriceTextView.paintFlags =
            originPriceTextView.paintFlags.or(Paint.STRIKE_THRU_TEXT_FLAG);

        val viewPager = root.findViewById<ViewPager2>(R.id.view_pager)
        val dummyList = listOf<String>(
            "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
            "http://public.codesquad.kr/jk/storeapp/data/side/17_ZIP_P_6014_T.jpg",
            "http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_T.jpg",
        )
        viewPager.adapter = ImageSliderAdapter(requireContext(), dummyList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                // 추후 수정 필요
                textViewIndex.text = "${position + 1}/${dummyList.size}"
            }
        })
        return root
    }
}