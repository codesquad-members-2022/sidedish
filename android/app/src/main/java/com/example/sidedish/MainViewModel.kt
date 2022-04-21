package com.example.sidedish

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: Repository) : ViewModel() {
    private val _mainMenu = MutableLiveData<List<MenuData>>()
    val mainMenu: LiveData<List<MenuData>> get() = _mainMenu

    init {
        getMainMenu()
    }

    private fun getMainMenu() = viewModelScope.launch {
        repository.getMainMenu().let {
            Log.d("뭐지", "$it")
            if (it.isSuccessful) {
                _mainMenu.postValue(it.body())
            } else {
                Log.d("reponse Error", "errorcode: ${it.code()}")
            }
        }
    }
}