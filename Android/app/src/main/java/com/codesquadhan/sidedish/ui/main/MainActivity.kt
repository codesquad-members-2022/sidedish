package com.codesquadhan.sidedish.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityMainBinding
import com.codesquadhan.sidedish.ui.detail.DetailActivity

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

    private fun setMainRv() {
        mainAdapter = makeMainAdapter()
        binding.rvMain.adapter = mainAdapter
        viewModel.menuMainListLd.observe(this) {
            mainAdapter.submitList(it.toList())
        }
    }

    private fun setSoupRv() {
        soupAdapter = makeMainAdapter()
        binding.rvSoup.adapter = soupAdapter
        viewModel.menuSoupListLd.observe(this) {
            soupAdapter.submitList(it.toList())
        }
    }

    private fun setSideRv() {
        sideAdapter = makeMainAdapter()
        binding.rvSide.adapter = sideAdapter
        viewModel.menuSideListLd.observe(this) {
            sideAdapter.submitList(it.toList())
        }
    }


    private fun makeMainAdapter(): MainAdapter {
        return MainAdapter { it ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
    }

    private fun rvTest() {
        viewModel.addMainListTest()
        viewModel.addSoupListTest()
        viewModel.addSideListTest()
    }
}