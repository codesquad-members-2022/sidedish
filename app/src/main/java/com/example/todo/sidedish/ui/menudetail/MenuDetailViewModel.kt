package com.example.todo.sidedish.ui.menudetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.sidedish.domain.OrderRepository
import com.example.todo.sidedish.domain.Repository
import com.example.todo.sidedish.domain.model.MenuDetail
import com.example.todo.sidedish.domain.model.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val CHANNEL = "#2022-android"
const val ICON_EMOJI = ":ghost:"
const val USER_NAME = "webhookbot"

@HiltViewModel
class MenuDetailViewModel @Inject constructor(
    private val menuRepository: Repository,
    private val orderRepository: OrderRepository
) : ViewModel() {

    private val detailInfo = MutableLiveData<MenuDetail>()
    val _detailInfo: LiveData<MenuDetail> = detailInfo
    private val thumbnailImages = MutableLiveData<List<String>>()
    val _thumbnailImages: LiveData<List<String>> = thumbnailImages

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _orderSuccess = MutableLiveData<Boolean>()
    val orderSuccess :LiveData<Boolean> = _orderSuccess

    fun getDetail(hash: String) {
        viewModelScope.launch {
            menuRepository.getDetail(hash)
                .onSuccess {
                    detailInfo.value = it
                    thumbnailImages.value = it.thumbnailImages
                }
                .onFailure { error ->
                    _errorMessage.value = error.message
                }
        }
    }

    fun saveOrder(orderMessage: String) {
        viewModelScope.launch {
            orderRepository.saveOrder(Order(CHANNEL, USER_NAME, orderMessage, ICON_EMOJI))
                .onSuccess { _orderSuccess.value = true }
                .onFailure { _orderSuccess.value = false }
        }
    }
}