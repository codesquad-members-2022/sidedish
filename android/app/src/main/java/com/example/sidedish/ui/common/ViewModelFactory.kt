package com.example.sidedish.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sidedish.repository.MainRemoteDataSource
import com.example.sidedish.repository.MainRepository
import com.example.sidedish.repository.ProductDetailRemoteDataSource
import com.example.sidedish.repository.ProductDetailRepository
import com.example.sidedish.ui.MainViewModel
import com.example.sidedish.ui.ProductDetailViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository =
                    ProductDetailRepository(ProductDetailRemoteDataSource())
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