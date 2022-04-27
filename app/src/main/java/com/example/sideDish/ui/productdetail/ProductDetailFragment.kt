package com.example.sideDish.ui.productdetail

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.example.sideDish.R
import com.example.sideDish.common.ViewModelFactory
import com.example.sideDish.data.Item
import com.example.sideDish.data.source.FoodRepository
import com.example.sideDish.databinding.FragmentProductDetailBinding
import java.text.DecimalFormat

class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    lateinit var viewModel: FoodDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this, ViewModelFactory(FoodRepository(), "hash")).get(
            FoodDetailViewModel::class.java
        )
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)

        binding.viewModel = viewModel
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

        viewModel.orderCount.observe(viewLifecycleOwner) {
            binding.stepper.value.text = it.toString()
            binding.textViewTotalCostFix.text =
                "${DecimalFormat("#,###").format(it * (viewModel.detail.value?.discountedPrice ?: 0))}${resources.getString(R.string.money_unit)}"
        }

        viewModel.detail.observe(viewLifecycleOwner) {
            binding.viewPager.adapter = ImageSliderAdapter(it.thumbImageUrls)
            binding.detail = it
        }
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // 추후 수정 필요 data binding 으로 옮기자
                binding.textViewImageIndex.text =
                    "${position + 1}/${viewModel.detail.value?.thumbImageUrls?.size}"
            }
        })
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("lastFragment", 1)
    }
}