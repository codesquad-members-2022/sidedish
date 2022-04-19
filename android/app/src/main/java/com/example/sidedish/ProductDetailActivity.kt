package com.example.sidedish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.sidedish.databinding.ActivityProductDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        binding.lifecycleOwner = this

        val assetLoader = AssetLoader()
        val test = assetLoader.getJsonString(applicationContext, "product_detail.json")
        Log.d("TAG",test ?: "")

    }
}