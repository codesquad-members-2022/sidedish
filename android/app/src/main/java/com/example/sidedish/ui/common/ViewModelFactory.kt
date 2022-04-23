package com.example.sidedish.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sidedish.repository.ProductDetailImageDataSource
import com.example.sidedish.repository.ProductDetailRepository
import com.example.sidedish.ui.ProductDetailViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            val repository =
                ProductDetailRepository(ProductDetailImageDataSource())
            return ProductDetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException(modelClass.name)
        }
    }

}