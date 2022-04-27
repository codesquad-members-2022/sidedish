package com.example.sideDish.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sideDish.data.source.FoodRepository
import com.example.sideDish.ui.foodlist.FoodListViewModel
import com.example.sideDish.ui.productdetail.FoodDetailViewModel

class ViewModelFactory(private val repository: FoodRepository , private val hash:String ="") : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FoodListViewModel::class.java) -> {
                FoodListViewModel(repository) as T
            }
            modelClass.isAssignableFrom(FoodDetailViewModel::class.java) -> {
                FoodDetailViewModel(repository , hash) as T
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }
}