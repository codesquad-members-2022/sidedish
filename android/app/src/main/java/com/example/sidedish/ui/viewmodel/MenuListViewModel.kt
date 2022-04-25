package com.example.sidedish.ui.viewmodel

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Body
import com.example.sidedish.data.Detail
import com.example.sidedish.data.MenuListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: MenuListRepository
) : ViewModel() {

    private val _mainMenuList = MutableLiveData<List<Body>>()
    val mainFoodList: LiveData<List<Body>> = _mainMenuList

    private val _soupMenuList = MutableLiveData<List<Body>>()
    val soupFoodList: LiveData<List<Body>> = _soupMenuList

    private val _sideMenuList = MutableLiveData<List<Body>>()
    val sideFoodList: LiveData<List<Body>> = _sideMenuList

    private val _selectedFoodDetail = MutableLiveData<Detail>()
    val selectedFoodDetail: LiveData<Detail> get() = _selectedFoodDetail

    private val _error = MutableLiveData<String>()
    val error = _error

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int> get() = _price

    private var detailPrice: Int = 0

    init {
        load()
        _count.value = 0
    }

    private fun load() {
        val supervisorJob = SupervisorJob()

        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }

        viewModelScope.launch(supervisorJob + ceh) {
            kotlin.runCatching {
                listOf(
                    async(Dispatchers.IO) { repository.getMainFoodList() },
                    async(Dispatchers.IO) { repository.getSoupFoodList() },
                    async(Dispatchers.IO) { repository.getSideFoodList() }
                ).awaitAll()
            }.onSuccess {
                val menuList = it
                _mainMenuList.value = menuList[0]
                _soupMenuList.value = menuList[1]
                _sideMenuList.value = menuList[2]
            }.onFailure {
                throw NetworkErrorException("network error")
            }
        }
    }

    fun loadFoodDetail(key: String) {

        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }

        viewModelScope.launch(ceh) {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getSelectedFoodDetail(key)
                }
            }.onSuccess {
                _selectedFoodDetail.value = it
                detailPrice = it?.prices?.get(0)?.toInt() ?: 0
                Log.d("ViewModel", "detailprice $detailPrice")
            }.onFailure {
                throw NetworkErrorException("network error")
            }
        }
    }

    fun addCount() {
        _count.value = (count.value)?.plus(1)
        calculateTotalAmount()
    }

    fun subtractCount() {
        if(count.value!! > 0) {
            _count.value = (count.value)?.minus(1)
        }
        calculateTotalAmount()
    }

    private fun calculateTotalAmount() {
        if(_count.value == 0) {
            _price.value = 0
        } else {

            _price.value = _count.value?.times(detailPrice)
            Log.d("ViewModel", "${_price.value}")
        }
    }

}