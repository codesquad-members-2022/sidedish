package com.example.sidedish.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sidedish.repository.*
import com.example.sidedish.ui.MainViewModel
import com.example.sidedish.ui.ProductDetailViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository =
                    ProductDetailRepository(ProductDetailRemoteDataSource(), ProductCountRemoteDataSource())
                ProductDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                val repository = MainRepository(MainRemoteDataSource())
                MainViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException(modelClass.name)
            }
        }
    }
}