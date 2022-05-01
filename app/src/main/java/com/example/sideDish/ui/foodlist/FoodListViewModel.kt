package com.example.sideDish.ui.foodlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sideDish.common.Event
import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item
import com.example.sideDish.data.source.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    private val remoteRepository: FoodRepository
) : ViewModel() {
    private val _openDetail = MutableLiveData<Event<Item.FoodInfo>>()
    val openDetail: LiveData<Event<Item.FoodInfo>> = _openDetail

    private val _mainItems = MutableLiveData<List<Item>>()
    private val _soupItems = MutableLiveData<List<Item>>()
    private val _sideItems = MutableLiveData<List<Item>>()

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    private var mainItemsCount = 0
    private var soupItemsCount = 0
    private var sideItemsCount = 0

    private suspend fun getMainItems(): List<Item> {
        val mainItems = remoteRepository.getMenu(FoodCategory.MAIN)
        mainItemsCount = mainItems.size
        return mainItems
    }

    private suspend fun getSoupItems(): List<Item> {
        val soupItems = remoteRepository.getMenu(FoodCategory.SOUP)
        soupItemsCount = soupItems.size
        return soupItems
    }

    private suspend fun getSideItems(): List<Item> {
        val sideItems = remoteRepository.getMenu(FoodCategory.SIDE)
        sideItemsCount = sideItems.size
        return sideItems
    }

    fun openDetail(foodInfo: Item.FoodInfo) {
        _openDetail.value = Event(foodInfo)

    }

    suspend fun updateItems(category: FoodCategory) {
        var targetItems: MutableLiveData<List<Item>>? = null
        val newItems: List<Item> =
            withContext(Dispatchers.IO) {
                when (category) {
                    FoodCategory.MAIN -> {
                        targetItems = _mainItems
                        getMainItems()
                    }
                    FoodCategory.SOUP -> {
                        targetItems = _soupItems
                        getSoupItems()
                    }
                    FoodCategory.SIDE -> {
                        targetItems = _sideItems
                        getSideItems()
                    }
                }
            }
        if (newItems.isEmpty()) return;


        val tempItems = targetItems?.value?.toMutableList() ?: mutableListOf()

        var sectionIndex = -1
        tempItems.forEachIndexed { itemIndex, item ->
            when (item) {
                is Item.Section -> {
                    if (item.category == category) {
                        sectionIndex = itemIndex
                        return@forEachIndexed
                    }
                }
                else -> {}
            }
        }

        if (sectionIndex == -1) {
            tempItems.addAll(newItems)
        } else {
            var removedIndex = 0
            for (index in sectionIndex + 1 until tempItems.size) {
                when (tempItems[index]) {
                    is Item.Section -> break
                    else -> removedIndex++
                }
            }
            tempItems.removeAll(tempItems.slice(sectionIndex..sectionIndex + removedIndex))
            tempItems.addAll(sectionIndex, newItems)
        }

        targetItems?.value = tempItems.toList()

        val newItemsList = mutableListOf<Item>()
        _mainItems.value?.let { newItemsList.addAll(it) }
        _soupItems.value?.let { newItemsList.addAll(it) }
        _sideItems.value?.let { newItemsList.addAll(it) }
        _items.value = newItemsList
    }
}