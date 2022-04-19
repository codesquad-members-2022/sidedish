package com.example.todo.sidedish.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.sidedish.common.Constants.MAIN_DISH
import com.example.todo.sidedish.common.Constants.SIDE_DISH
import com.example.todo.sidedish.common.Constants.SOUP_DISH
import com.example.todo.sidedish.common.Result
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuRepository: Repository,
) : ViewModel() {

    private val items =
        mutableMapOf<String, List<Menu>?>(MAIN_DISH to null, SOUP_DISH to null, SIDE_DISH to null)
    private val _menus = MutableLiveData<Map<String, List<Menu>?>>()
    val menus: LiveData<Map<String, List<Menu>?>> = _menus

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        getMenus()
    }

    fun getMenus() {
        viewModelScope.launch {
            launch {
                when (val result = menuRepository.getMain()) {
                    is Result.Success -> {
                        items[MAIN_DISH] = result.data
                        _menus.value = items
                    }
                    is Result.Error -> {
                        _errorMessage.value = result.message
                    }
                }
            }

            launch {
                when (val result = menuRepository.getSoup()) {
                    is Result.Success -> {
                        items[SOUP_DISH] = result.data
                        _menus.value = items
                    }
                    is Result.Error -> {
                        _errorMessage.value = result.message
                    }
                }
            }

            launch {
                when (val result = menuRepository.getSide()) {
                    is Result.Success -> {
                        items[SIDE_DISH] = result.data
                        _menus.value = items
                    }
                    is Result.Error -> {
                        _errorMessage.value = result.message
                    }
                }
            }
        }
    }
}