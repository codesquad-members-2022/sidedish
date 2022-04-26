package com.example.sideDish.ui.foodlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sideDish.common.Event
import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item
import com.example.sideDish.data.source.FoodRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodListViewModel(private val remoteRepository: FoodRemoteRepository) : ViewModel() {
    private val _openDetail = MutableLiveData<Event<Boolean>>()
    val openDetail: LiveData<Event<Boolean>> = _openDetail

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    private var mainItemsCount = 0
    private var soupItemsCount = 0
    private var sideItemsCount = 0

    private suspend fun getMainItems(): List<Item>? {
        val mainItems = remoteRepository.getMenu(FoodCategory.MAIN)
        mainItemsCount = mainItems?.size ?: 0
        return mainItems
    }

    private suspend fun getSoupItems(): List<Item>? {
        val soupItems = remoteRepository.getMenu(FoodCategory.SOUP)
        soupItemsCount = soupItems?.size ?: 0
        return soupItems
    }

    private suspend fun getSideItems(): List<Item>? {
        val sideItems = remoteRepository.getMenu(FoodCategory.SIDE)
        sideItemsCount = sideItems?.size ?: 0
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

    suspend fun updateItems(category: FoodCategory) {
        val newItems: List<Item> =
            withContext(Dispatchers.IO) {
                when (category) {
                    FoodCategory.MAIN -> getMainItems()
                    FoodCategory.SOUP -> getSoupItems()
                    FoodCategory.SIDE -> getSideItems()
                }
            } ?: kotlin.run { return }

        val tempItems = _items.value?.toMutableList() ?: mutableListOf()

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