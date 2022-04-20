package com.example.todo.sidedish.ui.menudetail

import androidx.lifecycle.ViewModel
import com.example.todo.sidedish.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MenuDetailViewModel  @Inject constructor(
    private val menuRepository: Repository,
) : ViewModel() {


}