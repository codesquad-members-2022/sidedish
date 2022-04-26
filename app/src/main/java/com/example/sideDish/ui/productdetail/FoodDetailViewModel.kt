package com.example.sideDish.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sideDish.data.model.FoodDetail
import com.example.sideDish.data.source.DetailRepository
import kotlinx.coroutines.launch

class FoodDetailViewModel(private val repository: DetailRepository) : ViewModel() {
    private val _detail = MutableLiveData<FoodDetail>()
    val detail: LiveData<FoodDetail> = _detail

    val orderCount = MutableLiveData<Int>(0)

    fun getDetail(hash: String) {
        viewModelScope.launch {
            _detail.value = repository.getDetail(hash)
        }
    }
}