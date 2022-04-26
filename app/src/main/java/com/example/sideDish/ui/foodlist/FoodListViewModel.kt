package com.example.sideDish.ui.foodlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sideDish.common.Event
import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item
import com.example.sideDish.data.source.FoodRepository

class FoodListViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _openDetail = MutableLiveData<Event<Boolean>>()
    val openDetail: LiveData<Event<Boolean>> = _openDetail

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    private var mainItemsCount = 0
    private var soupItemsCount = 0
    private var sideItemsCount = 0

    private fun getMainItems(): List<Item> {
        val mainItems = repository.getMainItems()
        mainItemsCount = mainItems.size
        return mainItems
    }

    private fun getSoupItems(): List<Item> {
        val soupItems = repository.getSoupItems()
        soupItemsCount = soupItems.size
        return soupItems
    }

    private fun getSideItems(): List<Item> {
        val sideItems = repository.getSideItems()
        sideItemsCount = sideItems.size
        return sideItems
    }

    fun openDetail() {
        _openDetail.value = Event(true)
    }

    fun getCategoryItemsCount(category: FoodCategory): Int {
        val count = when (category) {
            FoodCategory.MAIN -> mainItemsCount
            FoodCategory.SOUP -> soupItemsCount
            FoodCategory.SIDE -> sideItemsCount
        }
        return if (count == 0) 0
        else count - 1
    }

    fun updateItems(category: FoodCategory) {
        val tempItems = _items.value?.toMutableList() ?: mutableListOf()
        val newItems = when (category) {
            FoodCategory.MAIN -> getMainItems()
            FoodCategory.SOUP -> getSoupItems()
            FoodCategory.SIDE -> getSideItems()
        }

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

        _items.value = tempItems.toList()
    }
}