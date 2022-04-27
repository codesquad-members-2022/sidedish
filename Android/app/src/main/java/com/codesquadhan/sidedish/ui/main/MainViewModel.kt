package com.codesquadhan.sidedish.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.repository.LoginRepository
import com.codesquadhan.sidedish.data.repository.MenuRepository
import com.codesquadhan.sidedish.ui.common.ViewType.HEADER_VIEW_TYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import com.codesquadhan.sidedish.ui.common.addAllAndSetIsWhite
import kotlinx.coroutines.CoroutineExceptionHandler

@HiltViewModel
class MainViewModel @Inject constructor(private val menuRepository: MenuRepository, private val loginRepository: LoginRepository): ViewModel() {

    private val _menuMainListLd = MutableLiveData<List<MainResponseItem>>()
    private val menuMainList = mutableListOf<MainResponseItem>()
    val menuMainListLd: LiveData<List<MainResponseItem>> = _menuMainListLd

    private val _mainSectionMenuCountLd = MutableLiveData<Int>(0)
    val mainSectionMenuCountLd: LiveData<Int> = _mainSectionMenuCountLd

    private val _soupSectionMenuCountLd = MutableLiveData<Int>(0)
    val soupSectionMenuCountLd: LiveData<Int> = _soupSectionMenuCountLd

    private val _sideSectionMenuCountLd = MutableLiveData<Int>(0)
    val sideSectionMenuCountLd: LiveData<Int> = _sideSectionMenuCountLd

    // CEH
    val ceh = CoroutineExceptionHandler { _, exception ->
        println("Something happend: $exception")

     // 네트워크 통신 실패 시 화면 보여주기 처리하기

    }

    val loginCeh = CoroutineExceptionHandler { _, exception ->
        println("Login fail & Something happend: $exception")

        // 네트워크 통신 실패 시 화면 보여주기 처리하기

    }

    // 메인화면 세 가지 섹션 메뉴 가져오기
    fun getMainUIMenu(){
        viewModelScope.launch(ceh) {
            menuMainList.clear()

            val mainResponse = async { menuRepository.getMenuList("main") ?: throw RuntimeException("why..?") }
            val soupResponse = async { menuRepository.getMenuList("soup") ?: throw RuntimeException("why..?") }
            val sideResponse = async { menuRepository.getMenuList("side") ?: throw RuntimeException("why..?") }

            menuMainList.add(MainResponseItem( viewType = HEADER_VIEW_TYPE, headerText = "모두가 좋아하는\n든든한 메인 요리", itemCount = mainResponse.await().size))
            menuMainList.addAll(mainResponse.await())
            _menuMainListLd.value = menuMainList

            menuMainList.add(MainResponseItem( viewType = HEADER_VIEW_TYPE, headerText = "정성이 담긴\n뜨끈뜨끈 국물 요리", isWhite = false, itemCount = soupResponse.await().size))
            menuMainList.addAllAndSetIsWhite(soupResponse.await())
            _menuMainListLd.value = menuMainList

            menuMainList.add(MainResponseItem( viewType = HEADER_VIEW_TYPE, headerText = "식탁을 풍성하게 하는\n정갈한 밑반찬", itemCount = sideResponse.await().size))
            menuMainList.addAll(sideResponse.await())
            _menuMainListLd.value = menuMainList

            Log.d("AppTest", "total data : $menuMainList")
        }
    }

    // 로그인
    fun doLogin(){
        viewModelScope.launch(loginCeh) {
            loginRepository.doLogin()
        }
    }
}