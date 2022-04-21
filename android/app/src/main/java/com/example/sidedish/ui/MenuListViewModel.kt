package com.example.sidedish.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Body
import com.example.sidedish.data.Detail
import com.example.sidedish.data.MenuListDataSource
import com.example.sidedish.data.MenuListRepository
import com.example.sidedish.network.ApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: MenuListRepository
): ViewModel() {

//    private val foodListRepository = MenuListRepository(MenuListDataSource(ApiClient.create()))

    private val _mainFoodList = MutableLiveData<List<Body>>()
    val mainFoodList: LiveData<List<Body>> = _mainFoodList

    private val _soupFoodList = MutableLiveData<List<Body>>()
    val soupFoodList: LiveData<List<Body>> = _soupFoodList

    private val _sideFoodList = MutableLiveData<List<Body>>()
    val sideFoodList: LiveData<List<Body>> = _sideFoodList

    private val _selectedFoodDetail = MutableLiveData<Detail>()
    val selectedFoodDetail: LiveData<Detail> get() = _selectedFoodDetail

    init {
        viewModelScope.launch {
            load()
        }
    }

    private suspend fun load() {
//        _mainFoodList.value = foodListRepository.getMainFoodList()
//        _soupFoodList.value = foodListRepository.getSoupFoodList()
//        _sideFoodList.value = foodListRepository.getSideFoodList()
        _mainFoodList.value = repository.getMainFoodList()
        _soupFoodList.value = repository.getSoupFoodList()
        _sideFoodList.value = repository.getSideFoodList()
    }

    fun loadFoodDetail(key: String) {
        viewModelScope.launch {
            _selectedFoodDetail.postValue(repository.getSelectedFoodDetail(key))
            Log.d("MainDetailFromGson", "${repository.getSelectedFoodDetail(key)}")
            Log.d("MainDetailLiveData", "${_selectedFoodDetail.value}")
        }
    }

}