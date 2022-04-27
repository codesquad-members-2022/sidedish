package com.example.sidedish

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository) :
    ViewModel() {

    private val _image = MutableLiveData<List<ProductDetailTitleImageList>>()
    val imageTitleImageList: LiveData<List<ProductDetailTitleImageList>> = _image

    init {
        loadProductDetailImage()
    }

    private fun loadProductDetailImage() {
        val image = productDetailRepository.loadProductDetailImage()
        image?.let { image ->
            _image.value = image.productDetailTitleImageList
        }
    }
}