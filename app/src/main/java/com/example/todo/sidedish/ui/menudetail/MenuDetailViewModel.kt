package com.example.todo.sidedish.ui.menudetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.sidedish.domain.OrderRepository
import com.example.todo.sidedish.domain.Repository
import com.example.todo.sidedish.domain.model.MenuDetail
import com.example.todo.sidedish.domain.model.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

const val CHANNEL = "#2022-android"
const val ICON_EMOJI = ":ghost:"
const val USER_NAME = "webhookbot"
const val ORDER_SUCCESS = "ok"

@HiltViewModel
class MenuDetailViewModel @Inject constructor(
    private val menuRepository: Repository,
    private val orderRepository: OrderRepository,
) : ViewModel() {

    private val _detailInfo = MutableLiveData<MenuDetail>()
    val detailInfo: LiveData<MenuDetail> = _detailInfo

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _orderSuccess = MutableLiveData<Boolean>()
    val orderSuccess: LiveData<Boolean> = _orderSuccess

    private val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            Log.e("CoroutineException", ": ${throwable.message}")
            _errorMessage.value = "잘못된 접근입니다."
        }

    fun getDetail(hash: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val detailMenu = menuRepository.getDetail(hash)
            _detailInfo.value = detailMenu
        }
    }

    fun saveOrder(orderMessage: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val orderResult = orderRepository.saveOrder(Order(CHANNEL, USER_NAME, orderMessage, ICON_EMOJI))
            _orderSuccess.value = orderResult == ORDER_SUCCESS
        }
    }
}