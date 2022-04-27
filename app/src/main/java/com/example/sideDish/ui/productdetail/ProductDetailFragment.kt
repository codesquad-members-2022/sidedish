package com.example.sideDish.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.widget.ViewPager2
import com.example.sideDish.R
import com.example.sideDish.common.EventObserver
import com.example.sideDish.data.model.Item
import com.example.sideDish.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

const val DETAIL_HASH_KEY = "DETAIL_HASH_KEY"

/*const val PRODUCT_TITLE = */
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

        val hash = arguments?.getString(DETAIL_HASH_KEY)
        val title = arguments?.getString("title")
        hash?.let { viewModel.getDetail(it) }
        binding.textViewDetailTitle.text = title

        viewModel.exceptionOccur.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), "반찬 세부 정보를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()
            parentFragmentManager.beginTransaction().remove(this).commit()
            parentFragmentManager.popBackStack()
        })

        registerStepper()
        registerViewpager()

        return binding.root
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