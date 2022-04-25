package com.example.sideDish.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sideDish.data.source.FoodDetail
import com.example.sideDish.data.source.FoodRepository

class FoodDetailViewModel(private val repository: FoodRepository, hash: String) : ViewModel() {
    private val _detail = MutableLiveData<FoodDetail>()
    val detail: LiveData<FoodDetail> = _detail

    val orderCount = MutableLiveData<Int>(0)

    fun getDetail(hash: String) {
        _detail.value = repository.getFoodDetail(hash)
    }
}