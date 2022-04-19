package com.codesquadhan.sidedish.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter
    private lateinit var soupAdapter: MainAdapter
    private lateinit var sideAdapter: MainAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setMainRv()
        setSoupRv()
        setSideRv()
        setBtnGitHub()
    }

    private fun setBtnGitHub() {
        binding.btnGithub.setOnClickListener {
            binding.clLogin.visibility = View.GONE
            binding.clMain.visibility = View.VISIBLE

            // 로그인 후 가정
            rvTest()
        }
    }

    private fun setMainRv(){
        mainAdapter = MainAdapter()
        binding.rvMain.adapter = mainAdapter
        viewModel.menuMainListLd.observe(this){
            mainAdapter.submitList(it.toList())
        }
    }

    private fun setSoupRv(){
        soupAdapter = MainAdapter()
        binding.rvSoup.adapter = soupAdapter
        viewModel.menuSoupListLd.observe(this){
            soupAdapter.submitList(it.toList())
        }
    }

    private fun setSideRv(){
        sideAdapter = MainAdapter()
        binding.rvSide.adapter = sideAdapter
        viewModel.menuSideListLd.observe(this){
            sideAdapter.submitList(it.toList())
        }
    }

    private fun rvTest(){
        viewModel.addMainListTest()
        viewModel.addSoupListTest()
        viewModel.addSideListTest()
    }
}