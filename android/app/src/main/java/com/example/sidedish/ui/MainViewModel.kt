package com.example.sidedish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.model.Products
import com.example.sidedish.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _mainMenu = MutableLiveData<List<Products>>()
    val mainMenu: LiveData<List<Products>>
        get() = _mainMenu

    private val _soupMenu = MutableLiveData<List<Products>>()
    val soupMenu: LiveData<List<Products>>
        get() = _soupMenu

    private val _sideDish = MutableLiveData<List<Products>>()
    val sideDish: LiveData<List<Products>>
        get() = _sideDish

    init {
        loadMenu()
    }

    private fun loadMenu() {
        viewModelScope.launch {
            mainRepository.loadMainMenu().let {
                _mainMenu.value = it?.products
            }
            mainRepository.loadSoupMenu().let {
                _soupMenu.value = it?.products
            }
            mainRepository.loadSideDish().let {
                _sideDish.value = it?.products
            }
        }
    }
}