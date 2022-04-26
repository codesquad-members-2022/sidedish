package com.codesquadhan.sidedish.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesquadhan.sidedish.data.model.detail.DetailResponse
import com.codesquadhan.sidedish.data.model.detail.TopImageData
import com.codesquadhan.sidedish.data.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepository) :
    ViewModel() {

    private val _detailResponseLd = MutableLiveData<DetailResponse>()
    val detailResponseLd = _detailResponseLd

    private val _detailImageListLd = MutableLiveData<List<TopImageData>>()
    private val detailImageList = mutableListOf<TopImageData>()
    val detailImageListLd: LiveData<List<TopImageData>> = _detailImageListLd

    private val _vpImageListLd = MutableLiveData<List<TopImageData>>()
    private val vpImageList = mutableListOf<TopImageData>()
    val vpImageListLd: LiveData<List<TopImageData>> = _vpImageListLd

    private val _orderedFoodQuantityLD = MutableLiveData(1)
    val orderedFoodQuantityLD: LiveData<Int> = _orderedFoodQuantityLD

    fun getMenuDetail(id: Int) {
        viewModelScope.launch {
            val detailResponse =
                detailRepository.getMenuDetail(id) ?: throw RuntimeException("why..?")
            _detailResponseLd.value = detailResponse

            detailResponse.mainImage.forEachIndexed { index, url ->
                vpImageList.add(TopImageData(index + 1, url))
            }
            detailResponse.detailImage.forEachIndexed { index, url ->
                detailImageList.add(TopImageData(index + 1, url))
            }

            _vpImageListLd.value = vpImageList
            _detailImageListLd.value = detailImageList
        }
    }

    fun countUpOrDownOrderFoodQuantity(countUpOrDown: Int) {
        _orderedFoodQuantityLD.value?.let {
            when (countUpOrDown) {
                0 -> _orderedFoodQuantityLD.value = it + 1
                else -> _orderedFoodQuantityLD.value = if (it - 1 < 1) 1 else it - 1
            }
        }
    }

    fun orderFood(menuId: Int) {
        _orderedFoodQuantityLD.value?.let {
            viewModelScope.launch {
                val orderRequestResponse = detailRepository.orderFood(menuId, it)
                Log.d("되나", "$orderRequestResponse")
            }
        }
    }

}