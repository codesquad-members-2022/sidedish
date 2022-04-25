package com.example.sidedish.ui.viewmodel

import android.accounts.NetworkErrorException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.data.Body
import com.example.sidedish.data.Detail
import com.example.sidedish.data.MenuListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: MenuListRepository
) : ViewModel() {

    private val _mainMenuList = MutableLiveData<List<Body>>()
    val mainFoodList: LiveData<List<Body>> = _mainMenuList

    private val _soupMenuList = MutableLiveData<List<Body>>()
    val soupFoodList: LiveData<List<Body>> = _soupMenuList

    private val _sideMenuList = MutableLiveData<List<Body>>()
    val sideFoodList: LiveData<List<Body>> = _sideMenuList

    private val _selectedFoodDetail = MutableLiveData<Detail>()
    val selectedFoodDetail: LiveData<Detail> get() = _selectedFoodDetail

    private val _error = MutableLiveData<String>()
    val error = _error

    init {
        load()
    }

    private fun load() {
        val supervisorJob = SupervisorJob()

        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }

        viewModelScope.launch(supervisorJob + ceh) {
            kotlin.runCatching {
                listOf(
                    async(Dispatchers.IO) { repository.getMainFoodList() },
                    async(Dispatchers.IO) { repository.getSoupFoodList() },
                    async(Dispatchers.IO) { repository.getSideFoodList() }
                ).awaitAll()
            }.onSuccess {
                val menuList = it
                _mainMenuList.value = menuList[0]
                _soupMenuList.value = menuList[1]
                _sideMenuList.value = menuList[2]
            }.onFailure {
                throw NetworkErrorException("network error")
            }
        }
    }

    fun loadFoodDetail(key: String) {

        val ceh = CoroutineExceptionHandler { _, _ ->
            error.value = "네트워크 연결 실패"
        }

        viewModelScope.launch(ceh) {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getSelectedFoodDetail(key)
                }
            }.onSuccess {
                _selectedFoodDetail.value = it
            }.onFailure {
                throw NetworkErrorException("network error")
            }
        }
    }

}