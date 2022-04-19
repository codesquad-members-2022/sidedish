package com.codesquadhan.sidedish.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codesquadhan.sidedish.data.MenuData

class MainViewModel: ViewModel() {

    private val _menuMainListLd = MutableLiveData<MutableList<MenuData>>(mutableListOf())
    private val menuMainList = mutableListOf<MenuData>()
    val menuMainListLd: LiveData<MutableList<MenuData>> = _menuMainListLd

    private val _menuSoupListLd = MutableLiveData<MutableList<MenuData>>(mutableListOf())
    private val menuSoupList = mutableListOf<MenuData>()
    val menuSoupListLd: LiveData<MutableList<MenuData>> = _menuSoupListLd

    private val _menuSideListLd = MutableLiveData<MutableList<MenuData>>(mutableListOf())
    private val menuSideList = mutableListOf<MenuData>()
    val menuSideListLd: LiveData<MutableList<MenuData>> = _menuSideListLd


    fun addMainListTest(){
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
    }

}