package com.example.sideDish.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.sideDish.R
import com.example.sideDish.data.model.Item
import com.example.sideDish.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val viewModel by viewModels<FoodDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)

        viewModel.getDetail("HBBCC")

        setFoodInfoDummy()
        registerStepper()
        registerViewpager()

        return binding.root
    }

    private fun setFoodInfoDummy() {
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
    }

    private fun registerStepper() {
        binding.stepper.orderCount = viewModel.orderCount

        viewModel.orderCount.observe(viewLifecycleOwner) {
            val discountedPrice = viewModel.detail.value?.discountedPrice

            binding.stepper.value.text = it.toString()
            binding.textViewTotalCostFix.text =
                DecimalFormat("#,###").format(it * (discountedPrice?.filter { price -> price.isDigit() }
                    ?.toInt() ?: 0))
        }
    }

    private fun registerViewpager() {
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // 추후 수정 필요 data binding 으로 옮기자
                binding.textViewImageIndex.text =
                    "${position + 1}/${viewModel.detail.value?.thumbImageUrls?.size}"
            }
        })

        viewModel.detail.observe(viewLifecycleOwner) {
            binding.viewPager.adapter = ImageSliderAdapter(it.thumbImageUrls)
            binding.detail = it
        }
    }

}