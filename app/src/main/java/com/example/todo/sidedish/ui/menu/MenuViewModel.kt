package com.example.todo.sidedish.ui.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.domain.Repository
import com.example.todo.sidedish.domain.model.DishType
import com.example.todo.sidedish.domain.model.DishType.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuRepository: Repository,
) : ViewModel() {

    private val items =
        mutableMapOf<DishType, List<Menu>?>(MAIN_DISH to null, SOUP_DISH to null, SIDE_DISH to null)
    private val _menus = MutableLiveData<Map<DishType, List<Menu>?>>()
    val menus: LiveData<Map<DishType, List<Menu>?>> = _menus

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            Log.e("CoroutineException", ": ${throwable.message}")
            _errorMessage.value = "잘못된 접근입니다."
        }

    init {
        getMenus()
    }

    private fun getMenus() {
        viewModelScope.launch(coroutineExceptionHandler) {
            supervisorScope {
                launch {
                    val mainDish = menuRepository.getMain()
                    items[MAIN_DISH] = mainDish
                    _menus.value = items
                }

                launch {
                    val soupDish = menuRepository.getSoup()
                    items[SOUP_DISH] = soupDish
                    _menus.value = items
                }

                launch {
                    val sideDish = menuRepository.getSide()
                    items[SIDE_DISH] = sideDish
                    _menus.value = items
                }
            }
        }
    }
}