package com.example.todo.sidedish.ui.menudetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.sidedish.domain.Repository
import com.example.todo.sidedish.domain.model.MenuDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuDetailViewModel @Inject constructor(
    private val menuRepository: Repository
) : ViewModel() {

    private val detailInfo = MutableLiveData<MenuDetail>()
    val _detailInfo: LiveData<MenuDetail> = detailInfo
    private val thumbnailImages = MutableLiveData<List<String>>()
    val _thumbnailImages: LiveData<List<String>> = thumbnailImages

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun getDetail(hash: String) {
        viewModelScope.launch {
            menuRepository.getDetail(hash)
                .onSuccess {
                    detailInfo.value = it
                    thumbnailImages.value = it.thumbnailImages
                }
                .onFailure { error ->
                    _errorMessage.value = error.message
                }
        }
    }
}