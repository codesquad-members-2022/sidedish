package com.example.sidedish.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.model.Products
import com.example.sidedish.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _mainMenu = MutableLiveData<List<Products>>()
    val mainMenu: LiveData<List<Products>> = _mainMenu

    private val _soupMenu = MutableLiveData<List<Products>>()
    val soupMenu: LiveData<List<Products>> = _soupMenu

    private val _sideDish = MutableLiveData<List<Products>>()
    val sideDish: LiveData<List<Products>> = _sideDish

    init {
        loadMenu()
    }

    private fun loadMenu() {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.Main).launch {
                mainRepository.loadMainMenu().let {
                    _mainMenu.value = it?.products
                }
            }
            CoroutineScope(Dispatchers.Main).launch {
                mainRepository.loadSoupMenu().let {
                    _soupMenu.value = it?.products
                }
            }
            CoroutineScope(Dispatchers.Main).launch {
                mainRepository.loadSideDish().let {
                    _sideDish.value = it?.products
                }
            }
        }
    }
}