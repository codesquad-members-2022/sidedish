package com.example.sidedish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.model.CEHModel
import com.example.sidedish.model.Products
import com.example.sidedish.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _mainMenu = MutableLiveData<List<Products>>()
    val mainMenu: LiveData<List<Products>> = _mainMenu

    private val _soupMenu = MutableLiveData<List<Products>>()
    val soupMenu: LiveData<List<Products>> = _soupMenu

    private val _sideDish = MutableLiveData<List<Products>>()
    val sideDish: LiveData<List<Products>> = _sideDish

    private val _error = MutableLiveData<CEHModel>()
    val error: LiveData<CEHModel> = _error

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.stackTrace

        when (throwable) {
            is SocketException -> _error.value = CEHModel(throwable, "소켓관련 오류입니다.")
            is HttpException -> _error.value = CEHModel(throwable, "Http 관련 오류입니다")
            is UnknownHostException -> _error.value = CEHModel(throwable, "UnknownHost 오류입니다.")
            else -> _error.value = CEHModel(throwable, "알 수 없는 오류입니다.")
        }
    }

    init {
        loadMenu()
    }

    private fun loadMenu() {
        viewModelScope.launch(exceptionHandler) {
            launch(Dispatchers.Main) {
                mainRepository.loadMainMenu().let {
                    _mainMenu.value = it?.products
                }
            }
            launch(Dispatchers.Main) {
                mainRepository.loadSoupMenu().let {
                    _soupMenu.value = it?.products
                }
            }
            launch(Dispatchers.Main) {
                mainRepository.loadSideDish().let {
                    _sideDish.value = it?.products
                }
            }
        }
    }
}