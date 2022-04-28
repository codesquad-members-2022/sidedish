package com.example.sideDish.ui.productdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sideDish.common.Event
import com.example.sideDish.data.model.FoodDetail
import com.example.sideDish.data.model.isEmpty
import com.example.sideDish.data.source.DetailRepository
import com.example.sideDish.ui.foodlist.FoodListFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel() {
    private val _detail = MutableLiveData<FoodDetail>()
    val detail: LiveData<FoodDetail> = _detail

    private val _exceptionOccur = MutableLiveData<Event<Boolean>>()
    val exceptionOccur = _exceptionOccur

    val orderCount = MutableLiveData<Int>(0)

    private val ceh = CoroutineExceptionHandler { _, exception ->
        _exceptionOccur.value = Event(true)
        Log.d(FoodListFragment.TAG, "$exception")
    }

    fun getDetail(hash: String) {
        viewModelScope.launch(ceh) {
            val foodDetail = repository.getDetail(hash)
            if (!foodDetail.isEmpty()) {
                _detail.value = foodDetail
            }
        }
    }
}