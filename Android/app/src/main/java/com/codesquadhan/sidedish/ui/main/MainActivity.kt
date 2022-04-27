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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setMainRv()
        setBtnGitHub()
    }

    private fun setBtnGitHub() {
        binding.btnGithub.setOnClickListener {
           /* binding.clLogin.visibility = View.GONE
            binding.clMain.visibility = View.VISIBLE

            // 로그인 후 가정
            viewModel.getMainUIMenu()*/

            viewModel.doLogin()
        }
    }

    private fun setMainRv() {
        mainAdapter = makeMainAdapter()
        binding.rvMain.adapter = mainAdapter
        viewModel.menuMainListLd.observe(this) {
            mainAdapter.submitList(it.toList())
        }
    }


    private fun makeMainAdapter(): MainAdapter {
        return MainAdapter { it ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
    }

}