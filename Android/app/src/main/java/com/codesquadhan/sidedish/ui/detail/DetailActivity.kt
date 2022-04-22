package com.codesquadhan.sidedish.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var detailAdapter: DetailAdapter
    private val detailViewModel: DetailViewModel by viewModels()

    private val testUrlList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)


        setViewPager()
        setDeatil()

        setViewPagerListener()

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

    fun setViewPager(){
        viewPagerAdapter = ViewPagerAdapter(arrayListOf<String>())
        binding.vpDetail.apply {
            adapter = viewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        detailViewModel.vpImageListLd.observe(this){
            viewPagerAdapter.updateImageList(it)
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