package com.example.sideDish

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _mainItems = MutableLiveData<List<Item>>()
    val mainItems: LiveData<List<Item>> = _mainItems

    private val _soupItems = MutableLiveData<List<Item>>()
    val soupItems: LiveData<List<Item>> = _soupItems

    private val _sideItems = MutableLiveData<List<Item>>()
    val sideItems: LiveData<List<Item>> = _sideItems

    fun getMainItems() {
        _mainItems.value = repository.getMainItems()
    }

    fun getSoupItems() {
        _soupItems.value = repository.getSoupItems()
    }

    fun getSideItems() {
        _sideItems.value = repository.getSideItems()
    }
}