package com.codesquadhan.sidedish.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesquadhan.sidedish.data.model.MenuData
import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.repository.MenuRepository
import com.codesquadhan.sidedish.ui.constant.ViewType.HEADER_VIEW_TYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val menuRepository: MenuRepository): ViewModel() {

    private val _menuMainListLd = MutableLiveData<List<MainResponseItem>>()
    private val menuMainList = mutableListOf<MainResponseItem>()
    val menuMainListLd: LiveData<List<MainResponseItem>> = _menuMainListLd


    // 메인화면 세 가지 섹션 메뉴 가져오기
    fun getMainUIMenu(){
        viewModelScope.launch {
            menuMainList.clear()
            
            val mainResponse = async {  menuRepository.getMainMenu() }
            val soupResponse = async {  menuRepository.getSoupMenu() }
            val sideResponse = async {  menuRepository.getSideMenu() }


            if(mainResponse.await().isSuccessful){
                mainResponse.await().body()?.let {
                    menuMainList.add(MainResponseItem( viewType = HEADER_VIEW_TYPE, headerText = "모두가 좋아하는\n든든한 메인 요리"))
                    menuMainList.addAll(it)
                    Log.d("AppTest", "${menuMainList}")
                }
                _menuMainListLd.value = menuMainList
            }
            else{
                Log.d("AppTest", "메인 메뉴 조회 실패")
            }

            if(sideResponse.await().isSuccessful){
                sideResponse.await().body()?.let {
                    menuMainList.add(MainResponseItem( viewType = HEADER_VIEW_TYPE, headerText = "식탁을 풍성하게 하는\n정갈한 밑반찬"))
                    menuMainList.addAll(it)
                    Log.d("AppTest", "${menuMainList}")
                }
                _menuMainListLd.value = menuMainList
            }
            else{
                Log.d("AppTest", "사이드 메뉴 조회 실패")
            }

            if(soupResponse.await().isSuccessful){
                soupResponse.await().body()?.let {
                    menuMainList.add(MainResponseItem( viewType = HEADER_VIEW_TYPE, headerText = "정성이 담긴\n뜨끈뜨끈 국물 요리"))
                    menuMainList.addAll(it)
                    Log.d("AppTest", "${menuMainList}")
                }
                _menuMainListLd.value = menuMainList
            }
            else{
                Log.d("AppTest", "국물 메뉴 조회 실패")
            }




        }
    }
}