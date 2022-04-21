package com.example.sidedish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Body
import com.example.sidedish.data.Detail
import com.example.sidedish.data.MenuListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: MenuListRepository
): ViewModel() {

    private val _mainFoodList = MutableLiveData<List<Body>>()
    val mainFoodList: LiveData<List<Body>> = _mainFoodList

    private val _soupFoodList = MutableLiveData<List<Body>>()
    val soupFoodList: LiveData<List<Body>> = _soupFoodList

    private val _sideFoodList = MutableLiveData<List<Body>>()
    val sideFoodList: LiveData<List<Body>> = _sideFoodList

    private val _selectedFoodDetail = MutableLiveData<Detail>()
    val selectedFoodDetail: LiveData<Detail> get() = _selectedFoodDetail

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            launch { _mainFoodList.value = repository.getMainFoodList() }
            launch { _soupFoodList.value = repository.getSoupFoodList() }
            launch { _sideFoodList.value = repository.getSideFoodList() }
        }
    }

    fun loadFoodDetail(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedFoodDetail.postValue(repository.getSelectedFoodDetail(key))
        }
    }

}