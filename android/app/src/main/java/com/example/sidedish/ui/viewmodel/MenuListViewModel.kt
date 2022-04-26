package com.example.sidedish.ui.viewmodel

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Category
import com.example.sidedish.data.Menu
import com.example.sidedish.data.MenuListRepository
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

    private val _mainMenuList = MutableLiveData<List<Menu>>()
    val mainFoodList: LiveData<List<Menu>> = _mainMenuList

    private val _soupMenuList = MutableLiveData<List<Menu>>()
    val soupFoodList: LiveData<List<Menu>> = _soupMenuList

    private val _sideMenuList = MutableLiveData<List<Menu>>()
    val sideFoodList: LiveData<List<Menu>> = _sideMenuList

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
                    async(Dispatchers.IO) { repository.getMenuList(MAIN_MENU) },
                    async(Dispatchers.IO) { repository.getMenuList(SOUP) },
                    async(Dispatchers.IO) { repository.getMenuList(SIDE_MENU) }
                ).awaitAll()
            }.onSuccess {
//                val menuList = it
//                _mainMenuList.value = menuList[0]
//                _soupMenuList.value = menuList[1]
//                _sideMenuList.value = menuList[2]
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
                    repository.getSelectedFoodDetail(key)
                }
            }.onSuccess {
                _selectedFoodDetail.value = it
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