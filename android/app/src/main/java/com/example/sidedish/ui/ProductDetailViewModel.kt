package com.example.sidedish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.model.DetailImages
import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.repository.ProductDetailRepository
import com.example.sidedish.model.RepresentImages
import com.example.sidedish.ui.common.ButtonState
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository
) :
    ViewModel() {

    private val _productDetail = MutableLiveData<ProductDetail>()
    val productDetail: LiveData<ProductDetail> = _productDetail

    private val _representImage = MutableLiveData<List<RepresentImages>>()
    val representImage: LiveData<List<RepresentImages>> = _representImage

    private val _detailImage = MutableLiveData<List<DetailImages>>()
    val detailImage: LiveData<List<DetailImages>> = _detailImage

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    init {
        _quantity.value = 1
    }

    fun loadProductDetail(productId: Int) {
        viewModelScope.launch {
            val detail = productDetailRepository.loadProductDetail(productId)
            detail?.let {
                _productDetail.value = it
                _representImage.value = it.representImages
                _detailImage.value = it.detailImages
            }
        }
    }

    fun postProductCount(postRequest: PostRequest) {
        viewModelScope.launch {
            val errorMessage = productDetailRepository.orderProduct(postRequest)
            errorMessage?.let {
                _error.value = it
            }
        }
    }

    fun setQuantity(buttonState: ButtonState) {
        when (buttonState) {
            ButtonState.PLUS -> _quantity.value = _quantity.value?.plus(1)
            ButtonState.MINUS -> _quantity.value = _quantity.value?.minus(1)
        }
    }
}