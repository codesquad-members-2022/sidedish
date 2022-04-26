package com.codesquadhan.sidedish.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var detailAdapter: DetailAdapter
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val id = intent.getIntExtra("id", 0)
        Log.d("AppTest", "menuId : $id")

        setViewPagerListener()
        setViewPager()
        setDeatil()
        setDetailInfo()

        detailViewModel.getMenuDetail(id)
    }

    fun setViewPagerListener() {
        // 페이지 리스너 달아보기
        binding.vpDetail.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvCurrentPage.text = (position + 1).toString()
            }
        })

    }

    fun setDetailInfo(){
        detailViewModel.detailResponseLd.observe(this){
            binding.detailInfo = it
        }
    }

    fun setViewPager(){
        viewPagerAdapter = ViewPagerAdapter()
        binding.vpDetail.apply {
            adapter = viewPagerAdapter
            //orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        detailViewModel.vpImageListLd.observe(this){
            viewPagerAdapter.submitList(it.toList())
            binding.tvTotalPage.text = it.size.toString()
        }
    }

    fun setDeatil(){
        detailAdapter = DetailAdapter()
        binding.rvFoodDetail.apply {
            adapter = detailAdapter
        }

        detailViewModel.detailImageListLd.observe(this) {
            detailAdapter.submitList(it.toList())
        }
    }
}