package com.example.sideDish.ui.productdetail

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.sideDish.R
import com.example.sideDish.common.EventObserver
import com.example.sideDish.databinding.FragmentProductDetailBinding
import com.example.sideDish.ui.foodlist.DETAIL_HASH_KEY
import com.example.sideDish.ui.foodlist.TITLE_KEY
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val viewModel by viewModels<FoodDetailViewModel>()
    lateinit var hash: String
    lateinit var title: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false)

        binding.viewModel = viewModel

        showDetail()
        occurException()
        registerStepper()
        registerViewpager()
        orderProduct()
        observeOrderSuccess()

        return binding.root
    }

    private fun observeOrderSuccess() {
        viewModel.orderSuccess.observe(viewLifecycleOwner, EventObserver {
            val builder = AlertDialog.Builder(requireContext())
                .setMessage("해당 상품을 주문했습니다.")
                .setPositiveButton(
                    "확인"
                ) { _, _ -> }
                .create()
                .show()
            closeFragment()
        })
    }

    private fun occurException() {
        viewModel.exceptionOccur.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), "반찬 세부 정보를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()
            closeFragment()
        })
    }

    private fun closeFragment() {
        parentFragmentManager.beginTransaction().remove(this).commit()
        parentFragmentManager.popBackStack()
    }

    private fun orderProduct() {
        viewModel.orderOccur.observe(viewLifecycleOwner, EventObserver() {
            viewModel.order(
                title,
                binding.stepper.value.text.toString().toInt(),
                binding.textViewTotalCostFix.text.toString()
            )
        })
    }

    private fun showDetail() {
        hash = arguments?.getString(DETAIL_HASH_KEY).toString()
        title = arguments?.getString(TITLE_KEY).toString()
        hash?.let { viewModel.getDetail(it) }
        binding.textViewDetailTitle.text = title
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