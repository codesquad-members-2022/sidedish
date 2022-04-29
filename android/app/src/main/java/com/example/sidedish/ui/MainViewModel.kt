package com.example.sidedish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedish.model.Products
import com.example.sidedish.repository.MainRepository
import com.example.sidedish.ui.common.ThrowableState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.ArithmeticException
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

    private val _error = MutableLiveData<Pair<Throwable, ThrowableState>>()
    val error: LiveData<Pair<Throwable, ThrowableState>> = _error

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.stackTrace

        when (throwable) {
            is SocketException -> _error.value = Pair(throwable, ThrowableState.SOCKET_EXCEPTION)
            is HttpException -> _error.value = Pair(throwable, ThrowableState.HTTP_EXCEPTION)
            is UnknownHostException -> _error.value = Pair(throwable, ThrowableState.UNKNOWN_HOST_EXCEPTION)
            else -> _error.value = Pair(throwable, ThrowableState.EXCEPTION)
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