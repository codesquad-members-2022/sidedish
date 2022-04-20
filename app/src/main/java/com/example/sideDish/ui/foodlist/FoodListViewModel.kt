package com.example.sideDish.ui.foodlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sideDish.common.Event
import com.example.sideDish.data.Item
import com.example.sideDish.data.source.FoodRepository

class FoodListViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _mainItems = MutableLiveData<List<Item>>()
    val mainItems: LiveData<List<Item>> = _mainItems

    private val _soupItems = MutableLiveData<List<Item>>()
    val soupItems: LiveData<List<Item>> = _soupItems

    private val _sideItems = MutableLiveData<List<Item>>()
    val sideItems: LiveData<List<Item>> = _sideItems

    private val _openDetail = MutableLiveData<Event<Boolean>>()
    val openDetail: LiveData<Event<Boolean>> = _openDetail

    fun getMainItems() {
        _mainItems.value = repository.getMainItems()
    }

    fun getSoupItems() {
        _soupItems.value = repository.getSoupItems()
    }

    fun getSideItems() {
        _sideItems.value = repository.getSideItems()
    }

    fun openDetail() {
        _openDetail.value = Event(true)
    }
}