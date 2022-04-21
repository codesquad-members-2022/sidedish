package com.example.sideDish.ui.productdetail

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.sideDish.R
import com.example.sideDish.data.Item
import com.example.sideDish.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)

        //dummy
        binding.foodInfo = Item.FoodInfo(
            "초계국수_쿠킹박스",
            listOf(),
            listOf("새벽배송", "전국택배"),
            "건강한 가정 간편식 여름 국수",
            "H1AA9",
            "http://public.codesquad.kr/jk/storeapp/data/main/739_ZIP_P__T.jpg",
            "20,000원",
            "11,800원",
            "초계국수_쿠킹박스"
        )
        val dummyList = listOf<String>(
            "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
            "http://public.codesquad.kr/jk/storeapp/data/side/17_ZIP_P_6014_T.jpg",
            "http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_T.jpg",
        )
        binding.viewPager.adapter = ImageSliderAdapter(dummyList)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // 추후 수정 필요
                binding.textViewImageIndex.text = "${position + 1}/${dummyList.size}"
            }
        })
        return binding.root
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("lastFragment" ,1)
    }
}