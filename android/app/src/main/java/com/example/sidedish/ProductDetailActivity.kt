package com.example.sidedish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.sidedish.databinding.ActivityProductDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProductDetailActivity : AppCompatActivity() {

    private val viewModel: ProductDetailViewModel by viewModels { ViewModelFactory(this) }
    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        binding.lifecycleOwner = this

        with(binding.viewpagerProductDetail) {
            adapter = ProductDetailImageAdapter().apply {
                viewModel.imageImageList.observe(this@ProductDetailActivity) { image ->
                    submitList(image)
                }
            }

            TabLayoutMediator(binding.tabLayoutProductDetailIndicator, this) { tab, position ->
            }.attach()
        }
    }
}