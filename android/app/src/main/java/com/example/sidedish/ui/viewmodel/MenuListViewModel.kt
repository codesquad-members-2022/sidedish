package com.example.sidedish.ui.viewmodel

import android.accounts.NetworkErrorException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Body
import com.example.sidedish.data.Detail
import com.example.sidedish.data.MenuListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: MenuListRepository
): ViewModel() {

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

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            try {
                val menuList = listOf(
                async(Dispatchers.IO) { repository.getMainFoodList() },
                async(Dispatchers.IO) { repository.getSoupFoodList() },
                async(Dispatchers.IO) { repository.getSideFoodList() }
                ).awaitAll()

                _mainMenuList.value = menuList[0]
                _soupMenuList.value = menuList[1]
                _sideMenuList.value = menuList[2]
            }catch (e: Exception) {
                error.value = "네트워크 연결 실패"
            }

        }
    }

    fun loadFoodDetail(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedFoodDetail.postValue(repository.getSelectedFoodDetail(key))
        }
    }

}