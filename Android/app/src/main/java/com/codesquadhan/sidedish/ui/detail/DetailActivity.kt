package com.codesquadhan.sidedish.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityDetailBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var detailAdapter: DetailAdapter
    private val detailViewModel: DetailViewModel by viewModels()
    private var menuId = 0

    enum class Count(val value: Int) {
        UP(1),
        DOWN(-1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        menuId = intent.getIntExtra("id", 0)
        Log.d("AppTest", "menuId : $menuId")
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        setViewPagerListener()
        setViewPager()
        setDetail()
        setDetailInfo()
        countUpOrDownQuantity()
        setOrderFoodQuantity()
        orderFood(menuId)
        setOrderResultDialog()
        detailViewModel.getMenuDetail(menuId)
    }

    private fun setViewPagerListener() {
        // 페이지 리스너 달아보기
        binding.vpDetail.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvCurrentPage.text = (position + 1).toString()
            }
        })

    }

    private fun setDetailInfo() {
        detailViewModel.detailResponseLiveData.observe(this) {
            binding.detailInfo = it
        }
    }

    private fun setViewPager() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.vpDetail.apply {
            adapter = viewPagerAdapter
            //orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        detailViewModel.vpImageListLiveData.observe(this) {
            viewPagerAdapter.submitList(it.toList())
            binding.tvTotalPage.text = it.size.toString()
        }
    }

    private fun setDetail() {
        detailAdapter = DetailAdapter()
        binding.rvFoodDetail.apply {
            adapter = detailAdapter
        }

        detailViewModel.detailImageListLiveData.observe(this) {
            detailAdapter.submitList(it.toList())
        }
    }

    private fun countUpOrDownQuantity() {
        binding.ivCountDown.setOnClickListener {
            detailViewModel.countUpOrDownOrderFoodQuantity(Count.DOWN.value)
        }

        binding.ivCountUp.setOnClickListener {
            detailViewModel.countUpOrDownOrderFoodQuantity(Count.UP.value)
        }
    }

    private fun setOrderFoodQuantity() {
        detailViewModel.orderedFoodQuantityLiveData.observe(this) {
            binding.tvItemCount.text = it.toString()
        }
    }

    private fun orderFood(menuId: Int) {
        binding.btnOrder.setOnClickListener {
            detailViewModel.orderFood(menuId)
        }
    }

    private fun setOrderResultDialog() {
        detailViewModel.orderSuccessLiveData.observe(this) {
            if (it) {
                // 주문 성공 다이얼로그
                openDialog(getString(R.string.order_success_message))
            } else {
                // 주문 실패 다이얼로그
                openDialog(getString(R.string.order_fail_message))
            }
        }
    }

    private fun openDialog(message: String) { // 성공, 실패 둘다 확인 누르면 뒤로가기 처리
        MaterialAlertDialogBuilder(this)
            .setMessage(message)
            .setPositiveButton(getString(R.string.dialog_ok)) { dialog, which ->
                // Respond to positive button press
                onBackPressed()
            }
            .show()
    }

}
