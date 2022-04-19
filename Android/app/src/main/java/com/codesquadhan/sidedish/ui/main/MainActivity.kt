package com.codesquadhan.sidedish.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.data.Menu
import com.codesquadhan.sidedish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val menu = listOf<Menu>(
            Menu(6, "", "", 0, viewType = 1),
            Menu(1, "잡채", "맛있어요", 15000),
            Menu(2, "오리 주물럭 반조리", "감질맛 나는 매콤한 양념", 12460),
            Menu(3, "소갈비찜", "촉촉하게 벤 양념이 일품", 26100),
            Menu(4, "간장 코다리 찜", "쫀득한 코다리를 국내산 간장소스를 활용", 14900),
            Menu(5, "꼬막 비빔밥", "매콤하게 입맛 돋우는", 10900),
        )

        val mainAdapter = MainAdapter()
        binding.rvMain.adapter = mainAdapter
        mainAdapter.submitList(menu)

        setBtnGitHub()
    }

    private fun setBtnGitHub() {
        binding.btnGithub.setOnClickListener {
            binding.clLogin.visibility = View.GONE
            binding.clMain.visibility = View.VISIBLE
        }
    }
}