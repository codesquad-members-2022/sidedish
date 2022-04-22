package com.example.sideDish.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sideDish.data.source.FoodRepository
import com.example.sideDish.ui.foodlist.FoodListViewModel

class ViewModelFactory(private val repository: FoodRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FoodListViewModel::class.java)) {
            FoodListViewModel(repository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}