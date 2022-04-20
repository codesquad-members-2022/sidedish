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

        viewPagerAdapter = ViewPagerAdapter(arrayListOf<String>())
        binding.vpDetail.adapter = viewPagerAdapter
        binding.vpDetail.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        detailAdapter = DetailAdapter()
        binding.rvFoodDetail.adapter = detailAdapter
        detailViewModel.detailImageListLd.observe(this) {
            detailAdapter.submitList(it.toList())
        }

        setViewPagerListener()

        testUrlList.add("https://ww.namu.la/s/32b66f77ef969034adcbce3840d362f66470c1ade8b3b67e9859954467a61a77ffe24051fd4db50a6a5251acd242a9140df6fc120653c85407c5508b00e763d8b2b09754bbe86f5ec315d6c2bfa597a8dc287028f3608155e80c67801d60595d")
        testUrlList.add("https://imagescdn.gettyimagesbank.com/500/21/442/935/0/1298312835.jpg")
        viewPagerAdapter.updateImageList(testUrlList)

        binding.tvTotalPage.text = viewPagerAdapter.itemCount.toString()


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
}