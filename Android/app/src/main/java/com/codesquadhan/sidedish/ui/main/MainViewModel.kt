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

    private val _menuMainListLd = MutableLiveData<MutableList<MainResponseItem>>(mutableListOf())
    private val menuMainList = mutableListOf<MainResponseItem>()
    val menuMainListLd: LiveData<MutableList<MainResponseItem>> = _menuMainListLd

    private val _menuSoupListLd = MutableLiveData<MutableList<MainResponseItem>>(mutableListOf())
    private val menuSoupList = mutableListOf<MainResponseItem>()
    val menuSoupListLd: LiveData<MutableList<MainResponseItem>> = _menuSoupListLd

    private val _menuSideListLd = MutableLiveData<MutableList<MainResponseItem>>(mutableListOf())
    private val menuSideList = mutableListOf<MainResponseItem>()
    val menuSideListLd: LiveData<MutableList<MainResponseItem>> = _menuSideListLd


   /* fun addMainListTest(){
        menuMainList.add(MenuData(6, "", "", 0, viewType = 1, headerText = "모두가 좋아하는\n든든한 메인 요리"))
        menuMainList.add(MenuData(1, "잡채", "맛있어요", 15000))
        menuMainList.add(MenuData(2, "오리 주물럭 반조리", "감질맛 나는 매콤한 양념", 12460))
        menuMainList.add(MenuData(3, "소갈비찜", "촉촉하게 벤 양념이 일품", 26100))
        menuMainList.add(MenuData(4, "간장 코다리 찜", "쫀득한 코다리를 국내산 간장소스를 활용", 14900))
        menuMainList.add(MenuData(5, "꼬막 비빔밥", "매콤하게 입맛 돋우는", 10900))

        _menuMainListLd.value = menuMainList
    }

    fun addSoupListTest(){
        menuSoupList.add(MenuData(6, "", "", 0, viewType = 1, headerText = "정성이 담긴\n뜨끈뜨끈 국물 요리"))
        menuSoupList.add(MenuData(1, "잡채", "맛있어요", 15000))
        menuSoupList.add(MenuData(2, "오리 주물럭 반조리", "감질맛 나는 매콤한 양념", 12460))
        menuSoupList.add(MenuData(3, "소갈비찜", "촉촉하게 벤 양념이 일품", 26100))
        menuSoupList.add(MenuData(4, "간장 코다리 찜", "쫀득한 코다리를 국내산 간장소스를 활용", 14900))
        menuSoupList.add(MenuData(5, "꼬막 비빔밥", "매콤하게 입맛 돋우는", 10900))

        _menuSoupListLd.value = menuSoupList
    }

    fun addSideListTest(){
        menuSideList.add(MenuData(6, "", "", 0, viewType = 1, headerText = "식탁을 풍성하게 하는 \n정갈한 밑반찬"))
        menuSideList.add(MenuData(1, "잡채", "맛있어요", 15000))
        menuSideList.add(MenuData(2, "오리 주물럭 반조리", "감질맛 나는 매콤한 양념", 12460))
        menuSideList.add(MenuData(3, "소갈비찜", "촉촉하게 벤 양념이 일품", 26100))
        menuSideList.add(MenuData(4, "간장 코다리 찜", "쫀득한 코다리를 국내산 간장소스를 활용", 14900))
        menuSideList.add(MenuData(5, "꼬막 비빔밥", "매콤하게 입맛 돋우는", 10900))

        _menuSideListLd.value = menuSideList
    }*/

    // hilt test
    /*fun getMenu(){
        viewModelScope.launch {
            val response = menuRepository.getOnbanMenu()

            if(response.isSuccessful){
                Log.d("AppTest", "${response.body()}")
            }
            else{
                Log.d("AppTest", "통신 실패 ")
            }
        }
    }*/

    // 메인화면 세 가지 섹션 메뉴 가져오기
    fun getMainUIMenu(){
        viewModelScope.launch {
            val mainResponse = async {  menuRepository.getMainMenu() }
            val soupResponse = async {  menuRepository.getSoupMenu() }
            val sideResponse = async {  menuRepository.getSideMenu() }

            if(mainResponse.await().isSuccessful){
                mainResponse.await().body()?.let {
                    menuMainList.clear()
                    menuMainList.add(MainResponseItem("", -1, "", "","", 0, "", viewType = HEADER_VIEW_TYPE,
                        headerText = "모두가 좋아하는\n든든한 메인 요리"))
                    menuMainList.addAll(it)
                    Log.d("AppTest", "${menuMainList}")
                }
                _menuMainListLd.value = menuMainList
            }
            else{
                Log.d("AppTest", "메인 메뉴 조회 실패")
            }

            if(soupResponse.await().isSuccessful){
                soupResponse.await().body()?.let {
                    menuSoupList.clear()
                    menuSoupList.add(MainResponseItem("", -1, "", "","", 0, "", viewType = HEADER_VIEW_TYPE,
                        headerText = "정성이 담긴\n뜨끈뜨끈 국물 요리"))
                    menuSoupList.addAll(it)
                }
                _menuSoupListLd.value = menuSoupList
            }
            else{
                Log.d("AppTest", "국물 메뉴 조회 실패")
            }

            if(sideResponse.await().isSuccessful){
                sideResponse.await().body()?.let {
                    menuSideList.clear()
                    menuSideList.add(MainResponseItem("", -1, "", "","", 0, "", viewType = HEADER_VIEW_TYPE,
                        headerText = "식탁을 풍성하게 하는\n정갈한 밑반찬"))
                    menuSideList.addAll(it)
                }
                _menuSideListLd.value = menuSideList
            }
            else{
                Log.d("AppTest", "사이드 메뉴 조회 실패")
            }



        }
    }
}