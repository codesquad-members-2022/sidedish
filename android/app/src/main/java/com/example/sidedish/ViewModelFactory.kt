package com.example.sidedish

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            val repository = ProductDetailRepository(ProductDetailImageDataSource(AssetLoader(context)))
            return ProductDetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException(modelClass.name)
        }
    }
}