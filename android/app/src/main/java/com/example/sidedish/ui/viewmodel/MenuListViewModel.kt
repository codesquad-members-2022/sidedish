package com.example.sidedish.ui.viewmodel

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Menu
import com.example.sidedish.data.repository.MenuListRepository
import com.example.sidedish.data.MenuModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

private const val MAIN_MENU = 1
private const val SOUP = 2
private const val SIDE_MENU = 3

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: MenuListRepository
) : ViewModel() {
    private val _menu = MutableLiveData<List<MenuModel>>()
    val menu: LiveData<List<MenuModel>> = _menu

    private val _selectedFoodDetail = MutableLiveData<Menu>()
    val selectedFoodDetail: LiveData<Menu> get() = _selectedFoodDetail

    private val _error = MutableLiveData<String>()
    val error = _error

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int> get() = _price

    private val _detailPrice = MutableLiveData<Int>()

    private val _discountRate = MutableLiveData<Int>()

    private lateinit var jwt: String

    fun load() {
        _count.value = 0
        val supervisorJob = SupervisorJob()

        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }
        Log.d("TAG", jwt)
        viewModelScope.launch(supervisorJob + ceh) {
            kotlin.runCatching {
                listOf(
                    async(Dispatchers.IO) { repository.getMenuList(jwt, MAIN_MENU) },
                    async(Dispatchers.IO) { repository.getMenuList(jwt, SOUP) },
                    async(Dispatchers.IO) { repository.getMenuList(jwt, SIDE_MENU) }
                ).awaitAll()
            }.onSuccess {
                val menuList = mutableListOf<MenuModel>()
                it.forEach { item ->
                    menuList.addAll(item)
                }
                _menu.value = menuList
            }.onFailure {
                throw NetworkErrorException("network error")
            }
        }
    }

    fun loadFoodDetail(key: Int) {
        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }

        viewModelScope.launch(ceh) {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getSelectedFoodDetail(jwt, key)
                }
            }.onSuccess {
                _selectedFoodDetail.value = it
                _detailPrice.value =
                    it.let { it?.price!!.times((100 - it.discountRate!!)).div(100) }
            }.onFailure {
                throw NetworkErrorException("network error")
            }
        }
    }

    fun getJWT(code: String, move: (() -> (Unit))) {
        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }
        viewModelScope.launch(ceh) {
            jwt = repository.getJWT(code)
            Log.d("TAG", jwt)
            move()
        }
    }

    fun addCount() {
        _count.value = (count.value)?.plus(1)
        calculateTotalAmount()
    }

    fun subtractCount() {
        if (count.value!! > 0) {
            _count.value = (count.value)?.minus(1)
        }
        calculateTotalAmount()
    }

    private fun calculateTotalAmount() {
        if (_count.value == 0) {
            _price.value = 0
        } else {
            _price.value = _detailPrice.value?.let { _count.value?.times(it) }
        }
    }
}