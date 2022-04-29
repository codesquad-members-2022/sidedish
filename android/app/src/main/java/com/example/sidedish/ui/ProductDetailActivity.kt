package com.example.sidedish.ui

import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sidedish.R
import com.example.sidedish.databinding.ActivityProductDetailBinding
import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.Products
import com.example.sidedish.ui.common.ButtonState
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailActivity : AppCompatActivity() {

    private val viewModel: ProductDetailViewModel by viewModels()
    private lateinit var binding: ActivityProductDetailBinding
    lateinit var products: Products

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.loadProductDetail(loadProductId())

        with(binding.viewpagerProductDetail) {
            adapter = ProductDetailImageAdapter().apply {
                viewModel.representImage.observe(this@ProductDetailActivity) { image ->
                    submitList(image)
                }
            }

            TabLayoutMediator(binding.tabLayoutProductDetailIndicator, this) { tab, position ->
            }.attach()
        }

        binding.tvProductDetailContentsOriginalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

        binding.ibCountPlus.setOnClickListener {
            viewModel.setQuantity(ButtonState.PLUS)
        }

        binding.ibCountMinus.setOnClickListener {
            viewModel.setQuantity(ButtonState.MINUS)
        }

        viewModel.quantity.observe(this) { quantity ->
            binding.ibCountMinus.isEnabled = quantity > 1
        }

        binding.btnOrder.setOnClickListener {
            viewModel.postProductCount(makePostRequest())
        }

        viewModel.errorMessage.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadProductId(): Int {
        products = intent.getSerializableExtra("product") as Products
        return products.productId
    }

    private fun makePostRequest(): PostRequest {
        return PostRequest(
            loadProductId(),
            1234,
            replaceString(binding.tvCount.text.toString()).toInt(),
            replaceString(binding.tvTotalPrice.text.toString()).toInt()
        )
    }
    private fun replaceString(text: String): String {
        val strWithoutWon =  text.replace("원", "")
        return strWithoutWon.replace(",", "")
    }
}