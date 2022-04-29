package com.example.todo.sidedish.ui.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.sidedish.common.Constants
import com.example.todo.sidedish.common.LruMemoryCache
import com.example.todo.sidedish.data.remote.OnBanApi
import com.example.todo.sidedish.domain.Repository
import com.example.todo.sidedish.domain.model.DishType
import com.example.todo.sidedish.domain.model.DishType.*
import com.example.todo.sidedish.domain.model.Menu
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
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
            Log.e(Constants.COROUTINE_EXCEPTION_TAG, ": ${throwable.message}")
            _errorMessage.value = Constants.COROUTINE_ERROR
        }

    init {
        LruMemoryCache.initializeCache()
        getMenus()
    }

    private fun getMenus() {
        viewModelScope.launch(coroutineExceptionHandler) {
            launch {
                menuRepository.getMain()
                    .onSuccess {
                        items[MAIN_DISH] = it
                        _menus.value = items
                    }
                    .onFailure { _errorMessage.value = OnBanApi.ERROR_MESSAGE }
            }

            launch {
                menuRepository.getSoup()
                    .onSuccess {
                        items[SOUP_DISH] = it
                        _menus.value = items
                    }
                    .onFailure { _errorMessage.value = OnBanApi.ERROR_MESSAGE }
            }

            launch {
                menuRepository.getSide()
                    .onSuccess {
                        items[SIDE_DISH] = it
                        _menus.value = items
                    }
                    .onFailure { _errorMessage.value = OnBanApi.ERROR_MESSAGE }
            }
        }
    }
}
